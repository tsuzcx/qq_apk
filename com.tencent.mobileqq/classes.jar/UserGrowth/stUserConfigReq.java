package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUserConfigReq
  extends JceStruct
{
  public int config_set;
  public boolean is_auth = true;
  
  public stUserConfigReq() {}
  
  public stUserConfigReq(int paramInt, boolean paramBoolean)
  {
    this.config_set = paramInt;
    this.is_auth = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.config_set = paramJceInputStream.read(this.config_set, 0, false);
    this.is_auth = paramJceInputStream.read(this.is_auth, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.config_set, 0);
    paramJceOutputStream.write(this.is_auth, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stUserConfigReq
 * JD-Core Version:    0.7.0.1
 */