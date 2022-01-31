package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_decorate
  extends JceStruct
{
  static stcustomPraise cache_customPraise = new stcustomPraise();
  public stcustomPraise customPraise;
  
  public cell_decorate() {}
  
  public cell_decorate(stcustomPraise paramstcustomPraise)
  {
    this.customPraise = paramstcustomPraise;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.customPraise = ((stcustomPraise)paramJceInputStream.read(cache_customPraise, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.customPraise != null) {
      paramJceOutputStream.write(this.customPraise, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_decorate
 * JD-Core Version:    0.7.0.1
 */