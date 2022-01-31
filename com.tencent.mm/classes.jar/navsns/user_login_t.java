package navsns;

import com.tencent.tencentmap.mapsdk.a.nk;
import com.tencent.tencentmap.mapsdk.a.nl;
import com.tencent.tencentmap.mapsdk.a.nm;

public final class user_login_t
  extends nm
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
  
  public final void readFrom(nk paramnk)
  {
    this.user_id = paramnk.a(this.user_id, 0, true);
    this.session_id = paramnk.a(1, true);
    this.uin = paramnk.a(this.uin, 2, true);
    this.uip = paramnk.a(this.uip, 3, true);
    this.imei = paramnk.a(4, false);
    this.x = paramnk.a(this.x, 5, false);
    this.y = paramnk.a(this.y, 6, false);
    this.pf = paramnk.a(7, false);
    this.version = paramnk.a(8, false);
    this.is_login = paramnk.a(this.is_login, 9, false);
    this.fr = paramnk.a(10, false);
    this.nettp = paramnk.a(11, false);
    this.channel = paramnk.a(12, false);
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.user_id, 0);
    paramnl.a(this.session_id, 1);
    paramnl.a(this.uin, 2);
    paramnl.a(this.uip, 3);
    if (this.imei != null) {
      paramnl.a(this.imei, 4);
    }
    paramnl.a(this.x, 5);
    paramnl.a(this.y, 6);
    if (this.pf != null) {
      paramnl.a(this.pf, 7);
    }
    if (this.version != null) {
      paramnl.a(this.version, 8);
    }
    paramnl.a(this.is_login, 9);
    if (this.fr != null) {
      paramnl.a(this.fr, 10);
    }
    if (this.nettp != null) {
      paramnl.a(this.nettp, 11);
    }
    if (this.channel != null) {
      paramnl.a(this.channel, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     navsns.user_login_t
 * JD-Core Version:    0.7.0.1
 */