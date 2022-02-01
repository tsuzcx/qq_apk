package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFollowRsp
  extends JceStruct
{
  public int isFollow = 0;
  
  public stFollowRsp() {}
  
  public stFollowRsp(int paramInt)
  {
    this.isFollow = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.isFollow = paramJceInputStream.read(this.isFollow, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.isFollow, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stFollowRsp
 * JD-Core Version:    0.7.0.1
 */