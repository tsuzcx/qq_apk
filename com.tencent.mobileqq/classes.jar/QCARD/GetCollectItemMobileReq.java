package QCARD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetCollectItemMobileReq
  extends JceStruct
{
  public String appid = "";
  public String card_id = "";
  public int field;
  public long sequence;
  public long uin;
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.field = paramJceInputStream.read(this.field, 0, true);
    this.appid = paramJceInputStream.readString(1, true);
    this.card_id = paramJceInputStream.readString(2, true);
    this.sequence = paramJceInputStream.read(this.sequence, 3, true);
    this.uin = paramJceInputStream.read(this.uin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.field, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.card_id, 2);
    paramJceOutputStream.write(this.sequence, 3);
    paramJceOutputStream.write(this.uin, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QCARD.GetCollectItemMobileReq
 * JD-Core Version:    0.7.0.1
 */