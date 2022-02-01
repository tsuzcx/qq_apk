package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MaterialUserItem
  extends JceStruct
{
  static MaterialItem cache_stItem = new MaterialItem();
  public long lExpireTime = -1L;
  public long lSettleTime = 0L;
  public MaterialItem stItem = null;
  
  public MaterialUserItem() {}
  
  public MaterialUserItem(MaterialItem paramMaterialItem, long paramLong1, long paramLong2)
  {
    this.stItem = paramMaterialItem;
    this.lExpireTime = paramLong1;
    this.lSettleTime = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stItem = ((MaterialItem)paramJceInputStream.read(cache_stItem, 0, true));
    this.lExpireTime = paramJceInputStream.read(this.lExpireTime, 1, false);
    this.lSettleTime = paramJceInputStream.read(this.lSettleTime, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stItem, 0);
    paramJceOutputStream.write(this.lExpireTime, 1);
    paramJceOutputStream.write(this.lSettleTime, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.MaterialUserItem
 * JD-Core Version:    0.7.0.1
 */