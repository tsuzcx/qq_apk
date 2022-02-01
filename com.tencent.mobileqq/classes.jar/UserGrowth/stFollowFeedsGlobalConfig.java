package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stFollowFeedsGlobalConfig
  extends JceStruct
{
  public boolean showMute;
  
  public stFollowFeedsGlobalConfig() {}
  
  public stFollowFeedsGlobalConfig(boolean paramBoolean)
  {
    this.showMute = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.showMute = paramJceInputStream.read(this.showMute, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.showMute, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stFollowFeedsGlobalConfig
 * JD-Core Version:    0.7.0.1
 */