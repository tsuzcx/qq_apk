package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_lbs_event
  extends JceStruct
{
  static s_gps cache_gpsinfo = new s_gps();
  static ArrayList cache_usersinfo = new ArrayList();
  public int actiontype;
  public String actionurl = "";
  public String desc = "";
  public long event_id;
  public s_gps gpsinfo;
  public ArrayList usersinfo;
  
  static
  {
    s_user locals_user = new s_user();
    cache_usersinfo.add(locals_user);
  }
  
  public cell_lbs_event() {}
  
  public cell_lbs_event(int paramInt, String paramString1, ArrayList paramArrayList, s_gps params_gps, long paramLong, String paramString2)
  {
    this.actiontype = paramInt;
    this.actionurl = paramString1;
    this.usersinfo = paramArrayList;
    this.gpsinfo = params_gps;
    this.event_id = paramLong;
    this.desc = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.actiontype = paramJceInputStream.read(this.actiontype, 0, false);
    this.actionurl = paramJceInputStream.readString(1, false);
    this.usersinfo = ((ArrayList)paramJceInputStream.read(cache_usersinfo, 2, false));
    this.gpsinfo = ((s_gps)paramJceInputStream.read(cache_gpsinfo, 3, false));
    this.event_id = paramJceInputStream.read(this.event_id, 4, false);
    this.desc = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.actiontype, 0);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 1);
    }
    if (this.usersinfo != null) {
      paramJceOutputStream.write(this.usersinfo, 2);
    }
    if (this.gpsinfo != null) {
      paramJceOutputStream.write(this.gpsinfo, 3);
    }
    paramJceOutputStream.write(this.event_id, 4);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_lbs_event
 * JD-Core Version:    0.7.0.1
 */