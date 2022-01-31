package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PfaFriend
  extends JceStruct
{
  public int month_remain_limit;
  public int per_limit;
  public String rec_desc = "";
  public int type;
  public String uin = "";
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, true);
    this.type = paramJceInputStream.read(this.type, 1, true);
    this.rec_desc = paramJceInputStream.readString(2, false);
    this.month_remain_limit = paramJceInputStream.read(this.month_remain_limit, 3, false);
    this.per_limit = paramJceInputStream.read(this.per_limit, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.type, 1);
    if (this.rec_desc != null) {
      paramJceOutputStream.write(this.rec_desc, 2);
    }
    paramJceOutputStream.write(this.month_remain_limit, 3);
    paramJceOutputStream.write(this.per_limit, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.PfaFriend
 * JD-Core Version:    0.7.0.1
 */