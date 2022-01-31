package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomBubbleSkin
  extends JceStruct
{
  public int iItemId = -1;
  public long lHeadBgColor;
  public long lTextColor;
  public long lUin;
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
    if (this.strBubbleZipUrl != null) {
      paramJceOutputStream.write(this.strBubbleZipUrl, 1);
    }
    paramJceOutputStream.write(this.lUin, 2);
    paramJceOutputStream.write(this.lHeadBgColor, 3);
    paramJceOutputStream.write(this.lTextColor, 4);
    if (this.strFeedsPicUrl != null) {
      paramJceOutputStream.write(this.strFeedsPicUrl, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomBubbleSkin
 * JD-Core Version:    0.7.0.1
 */