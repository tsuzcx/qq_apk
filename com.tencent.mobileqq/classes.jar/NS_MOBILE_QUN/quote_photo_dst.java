package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class quote_photo_dst
  extends JceStruct
{
  public long albumhandset;
  public String albumid = "";
  public long batchid;
  public String desc = "";
  public int dst_type;
  public String qunid = "";
  
  public quote_photo_dst() {}
  
  public quote_photo_dst(int paramInt, String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3)
  {
    this.dst_type = paramInt;
    this.albumid = paramString1;
    this.batchid = paramLong1;
    this.desc = paramString2;
    this.albumhandset = paramLong2;
    this.qunid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dst_type = paramJceInputStream.read(this.dst_type, 0, false);
    this.albumid = paramJceInputStream.readString(1, false);
    this.batchid = paramJceInputStream.read(this.batchid, 2, false);
    this.desc = paramJceInputStream.readString(3, false);
    this.albumhandset = paramJceInputStream.read(this.albumhandset, 4, false);
    this.qunid = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dst_type, 0);
    String str = this.albumid;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.batchid, 2);
    str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    paramJceOutputStream.write(this.albumhandset, 4);
    str = this.qunid;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.quote_photo_dst
 * JD-Core Version:    0.7.0.1
 */