package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stOpDataItem
  extends JceStruct
{
  public String bgtime = "";
  public String edtime = "";
  public int mask = 0;
  public String sceneId = "";
  public String wmId = "";
  
  public stOpDataItem() {}
  
  public stOpDataItem(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.wmId = paramString1;
    this.sceneId = paramString2;
    this.mask = paramInt;
    this.bgtime = paramString3;
    this.edtime = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wmId = paramJceInputStream.readString(0, true);
    this.sceneId = paramJceInputStream.readString(1, true);
    this.mask = paramJceInputStream.read(this.mask, 2, true);
    this.bgtime = paramJceInputStream.readString(3, true);
    this.edtime = paramJceInputStream.readString(4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wmId, 0);
    paramJceOutputStream.write(this.sceneId, 1);
    paramJceOutputStream.write(this.mask, 2);
    paramJceOutputStream.write(this.bgtime, 3);
    paramJceOutputStream.write(this.edtime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     WMDBClientInterface.stOpDataItem
 * JD-Core Version:    0.7.0.1
 */