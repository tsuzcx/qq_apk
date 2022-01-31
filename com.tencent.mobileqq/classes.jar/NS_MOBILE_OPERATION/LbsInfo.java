package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LbsInfo
  extends JceStruct
{
  public int i_poi_num;
  public int i_poi_order_type;
  public int i_poi_type;
  public String lbs_frd = "";
  public int lbs_id;
  public String lbs_idnm = "";
  public String lbs_nm = "";
  public int lbs_type;
  public String lbs_x = "";
  public String lbs_y = "";
  public String s_lbs_id = "";
  
  public LbsInfo() {}
  
  public LbsInfo(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, int paramInt4, int paramInt5)
  {
    this.lbs_x = paramString1;
    this.lbs_y = paramString2;
    this.lbs_nm = paramString3;
    this.lbs_id = paramInt1;
    this.lbs_idnm = paramString4;
    this.lbs_frd = paramString5;
    this.lbs_type = paramInt2;
    this.s_lbs_id = paramString6;
    this.i_poi_num = paramInt3;
    this.i_poi_type = paramInt4;
    this.i_poi_order_type = paramInt5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lbs_x = paramJceInputStream.readString(0, false);
    this.lbs_y = paramJceInputStream.readString(1, false);
    this.lbs_nm = paramJceInputStream.readString(2, false);
    this.lbs_id = paramJceInputStream.read(this.lbs_id, 3, false);
    this.lbs_idnm = paramJceInputStream.readString(4, false);
    this.lbs_frd = paramJceInputStream.readString(5, false);
    this.lbs_type = paramJceInputStream.read(this.lbs_type, 6, false);
    this.s_lbs_id = paramJceInputStream.readString(7, false);
    this.i_poi_num = paramJceInputStream.read(this.i_poi_num, 8, false);
    this.i_poi_type = paramJceInputStream.read(this.i_poi_type, 9, false);
    this.i_poi_order_type = paramJceInputStream.read(this.i_poi_order_type, 10, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.lbs_x != null) {
      paramJceOutputStream.write(this.lbs_x, 0);
    }
    if (this.lbs_y != null) {
      paramJceOutputStream.write(this.lbs_y, 1);
    }
    if (this.lbs_nm != null) {
      paramJceOutputStream.write(this.lbs_nm, 2);
    }
    paramJceOutputStream.write(this.lbs_id, 3);
    if (this.lbs_idnm != null) {
      paramJceOutputStream.write(this.lbs_idnm, 4);
    }
    if (this.lbs_frd != null) {
      paramJceOutputStream.write(this.lbs_frd, 5);
    }
    paramJceOutputStream.write(this.lbs_type, 6);
    if (this.s_lbs_id != null) {
      paramJceOutputStream.write(this.s_lbs_id, 7);
    }
    paramJceOutputStream.write(this.i_poi_num, 8);
    paramJceOutputStream.write(this.i_poi_type, 9);
    paramJceOutputStream.write(this.i_poi_order_type, 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.LbsInfo
 * JD-Core Version:    0.7.0.1
 */