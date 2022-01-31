package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_get_my_item_req
  extends JceStruct
{
  public int iAppid;
  public long lUin;
  
  public material_get_my_item_req() {}
  
  public material_get_my_item_req(long paramLong, int paramInt)
  {
    this.lUin = paramLong;
    this.iAppid = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iAppid = paramJceInputStream.read(this.iAppid, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iAppid, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_get_my_item_req
 * JD-Core Version:    0.7.0.1
 */