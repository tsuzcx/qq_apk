package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomBubbleSkin
  extends JceStruct
{
  public int iItemId = -1;
  public long lHeadBgColor = 0L;
  public long lTextColor = 0L;
  public long lUin = 0L;
  public String strBubbleZipUrl = "";
  public String strFeedsPicUrl = "";
  
  public QzmallCustomBubbleSkin() {}
  
  public QzmallCustomBubbleSkin(int paramInt, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    this.iItemId = paramInt;
    this.strBubbleZipUrl = paramString1;
    this.lUin = paramLong1;
    this.lHeadBgColor = paramLong2;
    this.lTextColor = paramLong3;
    this.strFeedsPicUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, false);
    this.strBubbleZipUrl = paramJceInputStream.readString(1, false);
    this.lUin = paramJceInputStream.read(this.lUin, 2, false);
    this.lHeadBgColor = paramJceInputStream.read(this.lHeadBgColor, 3, false);
    this.lTextColor = paramJceInputStream.read(this.lTextColor, 4, false);
    this.strFeedsPicUrl = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    String str = this.strBubbleZipUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.lUin, 2);
    paramJceOutputStream.write(this.lHeadBgColor, 3);
    paramJceOutputStream.write(this.lTextColor, 4);
    str = this.strFeedsPicUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomBubbleSkin
 * JD-Core Version:    0.7.0.1
 */