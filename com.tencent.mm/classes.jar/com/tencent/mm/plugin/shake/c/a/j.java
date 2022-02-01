package com.tencent.mm.plugin.shake.c.a;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.plugin.shake.model.l.a;
import com.tencent.mm.plugin.shake.model.l.b;
import com.tencent.mm.plugin.shake.model.m;
import com.tencent.mm.protocal.protobuf.dav;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
  extends l.b
  implements h
{
  public static int PBw = 3;
  private e PBr;
  public Collection<a> PBs;
  private int PBt;
  private int PBu;
  private int PBv;
  private int Pze;
  private float lsA;
  private b.a lsF;
  private float lsz;
  private com.tencent.mm.modelgeo.d owr;
  
  public j(l.a parama)
  {
    super(parama);
    AppMethodBeat.i(28293);
    this.PBs = null;
    this.lsz = -85.0F;
    this.lsA = -1000.0F;
    this.Pze = -1000;
    this.PBt = 10001;
    this.PBu = 10002;
    this.PBv = 10003;
    this.lsF = new b.a()
    {
      public final boolean onGetLocation(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2, double paramAnonymousDouble3)
      {
        AppMethodBeat.i(273605);
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(273605);
          return true;
        }
        j.a(j.this, paramAnonymousFloat2);
        j.b(j.this, paramAnonymousFloat1);
        j.a(j.this, (int)paramAnonymousDouble2);
        AppMethodBeat.o(273605);
        return false;
      }
    };
    AppMethodBeat.o(28293);
  }
  
  public static void a(com.tencent.mm.plugin.shake.model.d paramd)
  {
    AppMethodBeat.i(28302);
    if ((paramd != null) && (paramd.field_sex == PBw))
    {
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acLz, Boolean.TRUE);
      long l = Util.nowSecond();
      bh.bCz();
      com.tencent.mm.model.c.ban().set(at.a.acLA, Long.valueOf(l));
    }
    try
    {
      paramd = new String(paramd.field_lvbuffer, "utf-8");
      if (paramd != null)
      {
        paramd = paramd.split(",");
        if (paramd.length == 4)
        {
          bh.bCz();
          com.tencent.mm.model.c.ban().set(at.a.acLs, Long.valueOf(paramd[0]));
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
  
  public static void b(com.tencent.mm.plugin.shake.model.d paramd)
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
          locala.rid = Util.getInt(str, 0);
          locala.rie = Util.getInt((String)localObject, 0);
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
  
  private void djg()
  {
    AppMethodBeat.i(28299);
    this.owr = com.tencent.mm.modelgeo.d.bJl();
    this.owr.a(this.lsF, true, true);
    l.kK(22, 10);
    AppMethodBeat.o(28299);
  }
  
  public final void gWH()
  {
    AppMethodBeat.i(28300);
    super.gWH();
    bh.aZW().b(658, this);
    AppMethodBeat.o(28300);
  }
  
  public final void init()
  {
    AppMethodBeat.i(28294);
    bh.aZW().a(658, this);
    djg();
    AppMethodBeat.o(28294);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(28301);
    if (this.Pzt == null)
    {
      AppMethodBeat.o(28301);
      return;
    }
    Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (e)paramp;
      if ((658 == paramp.getType()) && (paramString.action == 1))
      {
        paramString = (dav)c.c.b(paramString.oDw.otC);
        if (paramString.aaGr == null)
        {
          this.Pzt.g(null, 3L);
          AppMethodBeat.o(28301);
          return;
        }
        if (paramString.aaGr.aaGv == 0)
        {
          Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[] { paramString.aaGr.IHO, paramString.aaGr.MRj, Integer.valueOf(paramString.aaGr.aaGv) });
          paramString = paramString.aaGr.IHO;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        JSONArray localJSONArray = paramString.getJSONArray("msgs");
        paramp = paramString.getJSONObject("guide_switch");
        paramInt2 = paramp.getInt("channel_open_method");
        long l = paramp.getLong("channel_open_time");
        paramInt1 = paramp.getInt("shake_tab_display");
        int i = paramString.getJSONObject("gated_launch_option").getInt("tab_state");
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acLt, Integer.valueOf(paramInt2));
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acLu, Long.valueOf(l));
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acLv, Integer.valueOf(paramInt1));
        bh.bCz();
        com.tencent.mm.model.c.ban().set(at.a.acLE, Integer.valueOf(i));
        Log.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + paramInt2 + " ,channel_open_time is " + l + ", shake_tab_display is " + paramInt1);
        i = localJSONArray.length();
        paramString = null;
        com.tencent.mm.plugin.shake.model.e locale = m.gXd();
        locale.gWS();
        if (i > 0)
        {
          paramp = new ArrayList();
          paramInt1 = 0;
          paramString = paramp;
          if (paramInt1 < i)
          {
            paramString = new com.tencent.mm.plugin.shake.model.d();
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
              paramString.field_sex = PBw;
            }
            paramString.field_lvbuffer = (String.valueOf(str5) + "," + String.valueOf(str6) + "," + String.valueOf(str7) + "," + String.valueOf(localObject)).getBytes("utf-8");
            paramString.field_insertBatch = 2;
            paramString.field_reserved3 = (str8 + "," + str9 + "," + k);
            paramp.add(paramString);
            locale.a(paramString, true);
            if ((paramString.field_sex != PBw) || (paramInt2 != 1)) {
              break label967;
            }
            a(paramString);
            break label967;
          }
        }
        this.Pzt.g(paramString, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[] { Util.nullAsNil(paramString.getMessage()) });
        this.Pzt.g(null, 1L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.aaGr.aaGv == this.PBt)
      {
        this.Pzt.g(null, 6L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.aaGr.aaGv == this.PBu)
      {
        this.Pzt.g(null, 7L);
        AppMethodBeat.o(28301);
        return;
      }
      if (paramString.aaGr.aaGv == this.PBv)
      {
        this.Pzt.g(null, 8L);
        AppMethodBeat.o(28301);
        return;
      }
      this.Pzt.g(null, 1L);
      AppMethodBeat.o(28301);
      return;
      this.Pzt.g(null, 3L);
      AppMethodBeat.o(28301);
      return;
      label967:
      paramInt1 += 1;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(28297);
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
    AppMethodBeat.o(28297);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(28295);
    if (this.PBr != null) {
      bh.aZW().a(this.PBr);
    }
    AppMethodBeat.o(28295);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(28298);
    if (this.owr != null)
    {
      this.owr.a(this.lsF, true, true);
      l.kK(22, 10);
    }
    AppMethodBeat.o(28298);
  }
  
  public final void start()
  {
    AppMethodBeat.i(28296);
    Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
    init();
    reset();
    if (this.owr == null) {
      djg();
    }
    this.owr.a(this.lsF, true);
    l.kK(22, 10);
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23) && (!com.tencent.mm.modelgeo.d.bJm()))
    {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28290);
          j.a(j.this).g(null, 8L);
          AppMethodBeat.o(28290);
        }
      }, 1000L);
      AppMethodBeat.o(28296);
      return;
    }
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((localBluetoothAdapter != null) && (localBluetoothAdapter.getState() != 12))
    {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28291);
          j.b(j.this).g(null, 9L);
          AppMethodBeat.o(28291);
        }
      }, 1000L);
      AppMethodBeat.o(28296);
      return;
    }
    if (localBluetoothAdapter == null)
    {
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28292);
          j.c(j.this).g(null, 10L);
          AppMethodBeat.o(28292);
        }
      }, 1000L);
      AppMethodBeat.o(28296);
      return;
    }
    if (this.PBs != null) {}
    for (int i = this.PBs.size();; i = 0)
    {
      Log.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d", new Object[] { Integer.valueOf(i) });
      this.PBr = new e(this.PBs, this.lsz, this.lsA, this.Pze);
      bh.aZW().a(this.PBr, 0);
      AppMethodBeat.o(28296);
      return;
    }
  }
  
  public static final class a
  {
    public int PBA = 0;
    public String PBy = "";
    public double PBz = 0.0D;
    public int rid = 0;
    public int rie = 0;
    public double sgn = 0.0D;
    public String uuid = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.j
 * JD-Core Version:    0.7.0.1
 */