package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/ConnectivityCompat$WiFiScanResult;", "", "()V", "bssid", "", "getBssid", "()Ljava/lang/String;", "setBssid", "(Ljava/lang/String;)V", "level", "", "getLevel", "()I", "setLevel", "(I)V", "ssid", "getSsid", "setSsid", "fromStr", "", "str", "toStr", "toString", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ConnectivityCompat$WiFiScanResult
{
  private String bssid = "02:00:00:00:00:00";
  private int level;
  private String ssid = "<unknown ssid>";
  
  public final boolean fromStr(String paramString)
  {
    AppMethodBeat.i(244001);
    s.u(paramString, "str");
    try
    {
      paramString = n.a((CharSequence)paramString, new String[] { "," });
      setLevel(Integer.parseInt((String)paramString.get(0)));
      setBssid((String)paramString.get(1));
      paramString = Base64.decode((String)paramString.get(2), 2);
      s.s(paramString, "decode(this[2], Base64.NO_WRAP)");
      setSsid(new String(paramString, d.UTF_8));
      AppMethodBeat.o(244001);
      return true;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(244001);
    }
    return false;
  }
  
  public final String getBssid()
  {
    return this.bssid;
  }
  
  public final int getLevel()
  {
    return this.level;
  }
  
  public final String getSsid()
  {
    return this.ssid;
  }
  
  public final void setBssid(String paramString)
  {
    AppMethodBeat.i(243968);
    s.u(paramString, "<set-?>");
    this.bssid = paramString;
    AppMethodBeat.o(243968);
  }
  
  public final void setLevel(int paramInt)
  {
    this.level = paramInt;
  }
  
  public final void setSsid(String paramString)
  {
    AppMethodBeat.i(243957);
    s.u(paramString, "<set-?>");
    this.ssid = paramString;
    AppMethodBeat.o(243957);
  }
  
  public final String toStr()
  {
    AppMethodBeat.i(243992);
    Object localObject1 = new StringBuilder().append(this.level).append(',').append(this.bssid).append(',');
    Object localObject2 = this.ssid;
    Charset localCharset = d.UTF_8;
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(243992);
      throw ((Throwable)localObject1);
    }
    localObject2 = ((String)localObject2).getBytes(localCharset);
    s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
    localObject1 = Base64.encodeToString((byte[])localObject2, 2);
    AppMethodBeat.o(243992);
    return localObject1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(243983);
    String str = "ssid(" + this.ssid + "), bssid(" + this.bssid + "), level(" + this.level + ')';
    AppMethodBeat.o(243983);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ConnectivityCompat.WiFiScanResult
 * JD-Core Version:    0.7.0.1
 */