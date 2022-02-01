package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ElementInfo
  extends JceStruct
{
  static int cache_elementType;
  public int appid = 0;
  public String data = "";
  public int elementId = 0;
  public int elementType = 0;
  public int itemId = 0;
  
  public ElementInfo() {}
  
  public ElementInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.elementId = paramInt1;
    this.elementType = paramInt2;
    this.appid = paramInt3;
    this.itemId = paramInt4;
    this.data = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.elementId = paramJceInputStream.read(this.elementId, 0, false);
    this.elementType = paramJceInputStream.read(this.elementType, 1, false);
    this.appid = paramJceInputStream.read(this.appid, 2, false);
    this.itemId = paramJceInputStream.read(this.itemId, 3, false);
    this.data = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.elementId, 0);
    paramJceOutputStream.write(this.elementType, 1);
    paramJceOutputStream.write(this.appid, 2);
    paramJceOutputStream.write(this.itemId, 3);
    String str = this.data;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FACADE_DIY.ElementInfo
 * JD-Core Version:    0.7.0.1
 */