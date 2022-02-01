package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzoneDescription
  extends JceStruct
{
  static int cache_iType;
  public int iHeight = 0;
  public int iType = 0;
  public int iWidth = 0;
  public String strJumpUrl = "";
  public String strUrl = "";
  
  public QzoneDescription() {}
  
  public QzoneDescription(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    this.strUrl = paramString1;
    this.strJumpUrl = paramString2;
    this.iType = paramInt1;
    this.iHeight = paramInt2;
    this.iWidth = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strUrl = paramJceInputStream.readString(0, false);
    this.strJumpUrl = paramJceInputStream.readString(1, false);
    this.iType = paramJceInputStream.read(this.iType, 2, false);
    this.iHeight = paramJceInputStream.read(this.iHeight, 3, false);
    this.iWidth = paramJceInputStream.read(this.iWidth, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strJumpUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.iType, 2);
    paramJceOutputStream.write(this.iHeight, 3);
    paramJceOutputStream.write(this.iWidth, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.QzoneDescription
 * JD-Core Version:    0.7.0.1
 */