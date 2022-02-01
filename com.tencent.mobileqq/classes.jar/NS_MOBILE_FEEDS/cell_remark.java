package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_remark
  extends JceStruct
{
  static s_shoot_info cache_shoot_info = new s_shoot_info();
  public int action_type = 0;
  public String action_url = "";
  public String remark = "";
  public String remark_down = "";
  public String remark_up = "";
  public s_shoot_info shoot_info;
  public int time;
  
  public cell_remark() {}
  
  public cell_remark(String paramString1, String paramString2, String paramString3, int paramInt1, s_shoot_info params_shoot_info, int paramInt2, String paramString4)
  {
    this.remark = paramString1;
    this.remark_up = paramString2;
    this.remark_down = paramString3;
    this.time = paramInt1;
    this.shoot_info = params_shoot_info;
    this.action_type = paramInt2;
    this.action_url = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.remark = paramJceInputStream.readString(0, false);
    this.remark_up = paramJceInputStream.readString(1, false);
    this.remark_down = paramJceInputStream.readString(2, false);
    this.time = paramJceInputStream.read(this.time, 3, false);
    this.shoot_info = ((s_shoot_info)paramJceInputStream.read(cache_shoot_info, 4, false));
    this.action_type = paramJceInputStream.read(this.action_type, 5, false);
    this.action_url = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.remark;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.remark_up;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.remark_down;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.time, 3);
    localObject = this.shoot_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    paramJceOutputStream.write(this.action_type, 5);
    localObject = this.action_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_remark
 * JD-Core Version:    0.7.0.1
 */