package SummaryCardTaf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SSummaryCardLableRsp
  extends JceStruct
{
  static SUserLabel cache_likes;
  static int cache_ret;
  public SUserLabel likes = null;
  public String msg = "";
  public int ret = 0;
  
  public SSummaryCardLableRsp() {}
  
  public SSummaryCardLableRsp(int paramInt, String paramString, SUserLabel paramSUserLabel)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.likes = paramSUserLabel;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_likes == null) {
      cache_likes = new SUserLabel();
    }
    this.likes = ((SUserLabel)paramJceInputStream.read(cache_likes, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.likes != null) {
      paramJceOutputStream.write(this.likes, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCardTaf.SSummaryCardLableRsp
 * JD-Core Version:    0.7.0.1
 */