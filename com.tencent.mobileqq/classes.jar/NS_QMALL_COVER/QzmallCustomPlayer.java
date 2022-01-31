package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomPlayer
  extends JceStruct
{
  public int iItemId = -1;
  public long lTextColor;
  public String strPlayerDecoUrl = "";
  
  public QzmallCustomPlayer() {}
  
  public QzmallCustomPlayer(int paramInt, String paramString, long paramLong)
  {
    this.iItemId = paramInt;
    this.strPlayerDecoUrl = paramString;
    this.lTextColor = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strPlayerDecoUrl = paramJceInputStream.readString(1, false);
    this.lTextColor = paramJceInputStream.read(this.lTextColor, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strPlayerDecoUrl != null) {
      paramJceOutputStream.write(this.strPlayerDecoUrl, 1);
    }
    paramJceOutputStream.write(this.lTextColor, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomPlayer
 * JD-Core Version:    0.7.0.1
 */