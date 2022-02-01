package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PassiveProfileQzmallDeco
  extends JceStruct
{
  static ReturnToPraise cache_stReturnToPraise = new ReturnToPraise();
  public ReturnToPraise stReturnToPraise = null;
  
  public PassiveProfileQzmallDeco() {}
  
  public PassiveProfileQzmallDeco(ReturnToPraise paramReturnToPraise)
  {
    this.stReturnToPraise = paramReturnToPraise;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stReturnToPraise = ((ReturnToPraise)paramJceInputStream.read(cache_stReturnToPraise, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ReturnToPraise localReturnToPraise = this.stReturnToPraise;
    if (localReturnToPraise != null) {
      paramJceOutputStream.write(localReturnToPraise, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.PassiveProfileQzmallDeco
 * JD-Core Version:    0.7.0.1
 */