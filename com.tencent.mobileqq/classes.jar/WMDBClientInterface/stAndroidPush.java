package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stAndroidPush
  extends JceStruct
{
  public String content = "";
  public String keyname = "";
  public int mode = 0;
  public String sceneId = "";
  public String wmId = "";
  
  public stAndroidPush() {}
  
  public stAndroidPush(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this.content = paramString1;
    this.mode = paramInt;
    this.wmId = paramString2;
    this.sceneId = paramString3;
    this.keyname = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.content = paramJceInputStream.readString(0, true);
    this.mode = paramJceInputStream.read(this.mode, 1, true);
    this.wmId = paramJceInputStream.readString(2, true);
    this.sceneId = paramJceInputStream.readString(3, true);
    this.keyname = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.content, 0);
    paramJceOutputStream.write(this.mode, 1);
    paramJceOutputStream.write(this.wmId, 2);
    paramJceOutputStream.write(this.sceneId, 3);
    if (this.keyname != null) {
      paramJceOutputStream.write(this.keyname, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     WMDBClientInterface.stAndroidPush
 * JD-Core Version:    0.7.0.1
 */