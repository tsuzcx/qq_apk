package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_redbonus_man
  extends JceStruct
{
  static s_user cache_user = new s_user();
  public long payMoney;
  public long payTime;
  public s_user user;
  
  public s_redbonus_man() {}
  
  public s_redbonus_man(s_user params_user, long paramLong1, long paramLong2)
  {
    this.user = params_user;
    this.payTime = paramLong1;
    this.payMoney = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.payTime = paramJceInputStream.read(this.payTime, 1, false);
    this.payMoney = paramJceInputStream.read(this.payMoney, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.user != null) {
      paramJceOutputStream.write(this.user, 0);
    }
    paramJceOutputStream.write(this.payTime, 1);
    paramJceOutputStream.write(this.payMoney, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_redbonus_man
 * JD-Core Version:    0.7.0.1
 */