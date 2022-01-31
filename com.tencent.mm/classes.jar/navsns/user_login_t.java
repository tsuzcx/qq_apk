package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.k;
import com.tencent.tencentmap.mapsdk.maps.a.l;
import com.tencent.tencentmap.mapsdk.maps.a.m;

public final class user_login_t
  extends m
{
  public String channel = "";
  public String fr = "";
  public String imei = "";
  public boolean is_login = true;
  public String nettp = "";
  public String pf = "";
  public String session_id = "";
  public long uin = 0L;
  public int uip = 0;
  public long user_id = 0L;
  public String version = "";
  public double x = 0.0D;
  public double y = 0.0D;
  
  public user_login_t() {}
  
  public user_login_t(long paramLong1, String paramString1, long paramLong2, int paramInt, String paramString2, double paramDouble1, double paramDouble2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7)
  {
    this.user_id = paramLong1;
    this.session_id = paramString1;
    this.uin = paramLong2;
    this.uip = paramInt;
    this.imei = paramString2;
    this.x = paramDouble1;
    this.y = paramDouble2;
    this.pf = paramString3;
    this.version = paramString4;
    this.is_login = paramBoolean;
    this.fr = paramString5;
    this.nettp = paramString6;
    this.channel = paramString7;
  }
  
  public final void readFrom(k paramk)
  {
    AppMethodBeat.i(101145);
    this.user_id = paramk.a(this.user_id, 0, true);
    this.session_id = paramk.a(1, true);
    this.uin = paramk.a(this.uin, 2, true);
    this.uip = paramk.a(this.uip, 3, true);
    this.imei = paramk.a(4, false);
    this.x = paramk.a(this.x, 5, false);
    this.y = paramk.a(this.y, 6, false);
    this.pf = paramk.a(7, false);
    this.version = paramk.a(8, false);
    this.is_login = paramk.a(this.is_login, 9, false);
    this.fr = paramk.a(10, false);
    this.nettp = paramk.a(11, false);
    this.channel = paramk.a(12, false);
    AppMethodBeat.o(101145);
  }
  
  public final void writeTo(l paraml)
  {
    AppMethodBeat.i(101144);
    paraml.a(this.user_id, 0);
    paraml.a(this.session_id, 1);
    paraml.a(this.uin, 2);
    paraml.a(this.uip, 3);
    if (this.imei != null) {
      paraml.a(this.imei, 4);
    }
    paraml.a(this.x, 5);
    paraml.a(this.y, 6);
    if (this.pf != null) {
      paraml.a(this.pf, 7);
    }
    if (this.version != null) {
      paraml.a(this.version, 8);
    }
    paraml.a(this.is_login, 9);
    if (this.fr != null) {
      paraml.a(this.fr, 10);
    }
    if (this.nettp != null) {
      paraml.a(this.nettp, 11);
    }
    if (this.channel != null) {
      paraml.a(this.channel, 12);
    }
    AppMethodBeat.o(101144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     navsns.user_login_t
 * JD-Core Version:    0.7.0.1
 */