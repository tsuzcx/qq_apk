package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.euf;
import com.tencent.mm.protocal.protobuf.eug;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class h
  extends q
  implements m
{
  public eug OAb;
  public a OAc;
  private i callback;
  private final d rr;
  
  public h(int paramInt)
  {
    AppMethodBeat.i(182519);
    d.a locala = new d.a();
    euf localeuf = new euf();
    localeuf.UvH = paramInt;
    locala.lBU = localeuf;
    locala.lBV = new eug();
    locala.uri = "/cgi-bin/mmpay-bin/transferphonegetswitch";
    locala.funcId = 1813;
    this.rr = locala.bgN();
    AppMethodBeat.o(182519);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(69545);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(69545);
    return i;
  }
  
  public final int getType()
  {
    return 1813;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(69546);
    Log.w("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "errType = %s errCode = %s errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      this.OAb = ((eug)d.c.b(((d)params).lBS));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(69546);
  }
  
  public static final class a
  {
    public boolean OAd;
    public String OzR;
    public boolean tpu;
    public int tqa;
    public String tqb;
    public String wording;
    
    public static a bgJ(String paramString)
    {
      AppMethodBeat.i(69543);
      a locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.tqa = paramString.optInt("ret_code");
        locala.tqb = paramString.optString("ret_msg");
        locala.tpu = paramString.optBoolean("is_show");
        locala.OAd = paramString.optBoolean("is_open");
        locala.OzR = paramString.optString("entrance_name");
        locala.wording = paramString.optString("wording");
        AppMethodBeat.o(69543);
        return locala;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "createFromJSONObject() Exception:%s", new Object[] { paramString.getMessage() });
        }
      }
    }
    
    public final String gHs()
    {
      AppMethodBeat.i(69542);
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("ret_code", this.tqa);
        ((JSONObject)localObject).put("ret_msg", this.tqb);
        ((JSONObject)localObject).put("is_show", this.tpu);
        ((JSONObject)localObject).put("is_open", this.OAd);
        ((JSONObject)localObject).put("entrance_name", this.OzR);
        ((JSONObject)localObject).put("wording", this.wording);
        localObject = ((JSONObject)localObject).toString();
        AppMethodBeat.o(69542);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.mobileRemit.NetSceneMobileRemitGetSwitch", "MobileRemitSwitchConfig getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
        AppMethodBeat.o(69542);
      }
      return "";
    }
    
    public final String toString()
    {
      AppMethodBeat.i(69541);
      String str = "MobileRemitSwitchConfig{ret_code=" + this.tqa + ", ret_msg='" + this.tqb + '\'' + ", is_show=" + this.tpu + ", is_open=" + this.OAd + ", entrance_name='" + this.OzR + '\'' + ", wording='" + this.wording + '\'' + '}';
      AppMethodBeat.o(69541);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.h
 * JD-Core Version:    0.7.0.1
 */