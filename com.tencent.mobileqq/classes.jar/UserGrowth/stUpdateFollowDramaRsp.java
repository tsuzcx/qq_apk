package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUpdateFollowDramaRsp
  extends JceStruct
{
  public int isFollow = 0;
  
  public stUpdateFollowDramaRsp() {}
  
  public stUpdateFollowDramaRsp(int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stUpdateFollowDramaRsp
 * JD-Core Version:    0.7.0.1
 */