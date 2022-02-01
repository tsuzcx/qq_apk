package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stVersions
  extends JceStruct
{
  public int adVersion = 0;
  public int androidPushVersion = 0;
  public int flashSceenVersion = 0;
  public int opVersion = 0;
  public int watermarkVersion = 0;
  public int watermarkVersionAdv = 0;
  public int watermarkVersionInt = 0;
  public int wmResourceVersion = 0;
  
  public stVersions() {}
  
  public stVersions(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.watermarkVersion = paramInt1;
    this.wmResourceVersion = paramInt2;
    this.flashSceenVersion = paramInt3;
    this.androidPushVersion = paramInt4;
    this.adVersion = paramInt5;
    this.opVersion = paramInt6;
    this.watermarkVersionInt = paramInt7;
    this.watermarkVersionAdv = paramInt8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.watermarkVersion = paramJceInputStream.read(this.watermarkVersion, 0, true);
    this.wmResourceVersion = paramJceInputStream.read(this.wmResourceVersion, 1, true);
    this.flashSceenVersion = paramJceInputStream.read(this.flashSceenVersion, 2, true);
    this.androidPushVersion = paramJceInputStream.read(this.androidPushVersion, 3, true);
    this.adVersion = paramJceInputStream.read(this.adVersion, 4, true);
    this.opVersion = paramJceInputStream.read(this.opVersion, 5, true);
    this.watermarkVersionInt = paramJceInputStream.read(this.watermarkVersionInt, 6, false);
    this.watermarkVersionAdv = paramJceInputStream.read(this.watermarkVersionAdv, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.watermarkVersion, 0);
    paramJceOutputStream.write(this.wmResourceVersion, 1);
    paramJceOutputStream.write(this.flashSceenVersion, 2);
    paramJceOutputStream.write(this.androidPushVersion, 3);
    paramJceOutputStream.write(this.adVersion, 4);
    paramJceOutputStream.write(this.opVersion, 5);
    paramJceOutputStream.write(this.watermarkVersionInt, 6);
    paramJceOutputStream.write(this.watermarkVersionAdv, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     WMDBClientInterface.stVersions
 * JD-Core Version:    0.7.0.1
 */