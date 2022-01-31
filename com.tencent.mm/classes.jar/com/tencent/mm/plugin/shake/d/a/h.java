package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.l.a;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.protocal.c.apv;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static int oaR = 3;
  private float dia = -85.0F;
  private float dib = -1000.0F;
  private a.a dig = new h.1(this);
  private com.tencent.mm.modelgeo.c egs;
  private int nMD = -1000;
  private d oaM;
  public Collection<h.a> oaN = null;
  private int oaO = 10001;
  private int oaP = 10002;
  private int oaQ = 10003;
  
  public h(l.a parama)
  {
    super(parama);
  }
  
  public static void a(com.tencent.mm.plugin.shake.b.d paramd)
  {
    if ((paramd != null) && (paramd.field_sex == oaR))
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.urc, Boolean.valueOf(true));
      long l = bk.UX();
      au.Hx();
      com.tencent.mm.model.c.Dz().c(ac.a.urd, Long.valueOf(l));
    }
    try
    {
      paramd = new String(paramd.field_lvbuffer, "utf-8");
      if (paramd != null)
      {
        paramd = paramd.split(",");
        if (paramd.length == 4)
        {
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqV, Long.valueOf(paramd[0]));
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
        paramd = null;
      }
    }
  }
  
  public static void b(com.tencent.mm.plugin.shake.b.d paramd)
  {
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
          locala.dCX = paramd;
          locala.major = bk.getInt(str, 0);
          locala.minor = bk.getInt((String)localObject, 0);
        }
      }
      return;
    }
    catch (UnsupportedEncodingException paramd)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ShakeIbeaconService", paramd, "%s", new Object[] { "Unsupported" });
        paramd = null;
      }
    }
  }
  
  private void bzG()
  {
    this.egs = com.tencent.mm.modelgeo.c.Ob();
    this.egs.a(this.dig, true);
  }
  
  public final void bzH()
  {
    super.bzH();
    au.Dk().b(658, this);
  }
  
  public final void init()
  {
    au.Dk().a(658, this);
    bzG();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (d)paramm;
      if ((658 == paramm.getType()) && (paramString.action == 1))
      {
        paramString = (apv)paramString.esv.ecF.ecN;
        if (paramString.tlQ.sML != 0) {
          break label768;
        }
        y.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", new Object[] { paramString.tlQ.kSz, paramString.tlQ.mSC, Integer.valueOf(paramString.tlQ.sML) });
        paramString = paramString.tlQ.kSz;
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
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uqW, Integer.valueOf(paramInt2));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uqX, Long.valueOf(l));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.uqY, Integer.valueOf(paramInt1));
        au.Hx();
        com.tencent.mm.model.c.Dz().c(ac.a.urh, Integer.valueOf(i));
        y.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + paramInt2 + " ,channel_open_time is " + l + ", shake_tab_display is " + paramInt1);
        i = localJSONArray.length();
        paramString = null;
        e locale = com.tencent.mm.plugin.shake.b.m.bzU();
        locale.bzM();
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
              paramString.field_sex = oaR;
            }
            paramString.field_lvbuffer = (String.valueOf(str5) + "," + String.valueOf(str6) + "," + String.valueOf(str7) + "," + String.valueOf(localObject)).getBytes("utf-8");
            paramString.field_insertBatch = 2;
            paramString.field_reserved3 = (str8 + "," + str9 + "," + k);
            paramm.add(paramString);
            locale.a(paramString, true);
            if ((paramString.field_sex != oaR) || (paramInt2 != 1)) {
              break label878;
            }
            a(paramString);
            break label878;
          }
        }
        this.nYU.a(paramString, 1L);
        return;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", new Object[] { bk.pm(paramString.getMessage()) });
        this.nYU.a(null, 1L);
        return;
      }
      label768:
      if (paramString.tlQ.sML == this.oaO)
      {
        this.nYU.a(null, 6L);
        return;
      }
      if (paramString.tlQ.sML == this.oaP)
      {
        this.nYU.a(null, 7L);
        return;
      }
      if (paramString.tlQ.sML == this.oaQ)
      {
        this.nYU.a(null, 8L);
        return;
      }
      this.nYU.a(null, 1L);
      return;
      this.nYU.a(null, 3L);
      return;
      label878:
      paramInt1 += 1;
    }
  }
  
  public final void pause()
  {
    if (this.egs != null) {
      this.egs.c(this.dig);
    }
  }
  
  public final void reset()
  {
    if (this.oaM != null) {
      au.Dk().c(this.oaM);
    }
  }
  
  public final void resume()
  {
    if (this.egs != null) {
      this.egs.a(this.dig, true);
    }
  }
  
  public final void start()
  {
    y.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
    init();
    reset();
    if (this.egs == null) {
      bzG();
    }
    this.egs.b(this.dig, true);
    Object localObject;
    if ((!Build.VERSION.RELEASE.equals("6.0")) && (!Build.VERSION.RELEASE.equals("6.0.0")) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = (LocationManager)ae.getContext().getSystemService("location");
      if (localObject == null) {
        break label271;
      }
    }
    label271:
    for (boolean bool = ((LocationManager)localObject).isProviderEnabled("gps");; bool = true)
    {
      if (!bool)
      {
        new ah().postDelayed(new h.2(this), 1000L);
        return;
      }
      localObject = BluetoothAdapter.getDefaultAdapter();
      if ((localObject != null) && (((BluetoothAdapter)localObject).getState() != 12))
      {
        new ah().postDelayed(new h.3(this), 1000L);
        return;
      }
      if (localObject == null)
      {
        new ah().postDelayed(new h.4(this), 1000L);
        return;
      }
      if (this.oaN != null) {}
      for (int i = this.oaN.size();; i = 0)
      {
        y.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d", new Object[] { Integer.valueOf(i) });
        this.oaM = new d(this.oaN, this.dia, this.dib, this.nMD);
        au.Dk().a(this.oaM, 0);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.h
 * JD-Core Version:    0.7.0.1
 */