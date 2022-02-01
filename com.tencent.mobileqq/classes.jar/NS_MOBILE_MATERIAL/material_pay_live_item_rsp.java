package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_pay_live_item_rsp
  extends JceStruct
{
  public int iCode = 0;
  
  public material_pay_live_item_rsp() {}
  
  public material_pay_live_item_rsp(int paramInt)
  {
    this.iCode = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_pay_live_item_rsp
 * JD-Core Version:    0.7.0.1
 */