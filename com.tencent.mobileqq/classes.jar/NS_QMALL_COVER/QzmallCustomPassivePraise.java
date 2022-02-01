package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QzmallCustomPassivePraise
  extends JceStruct
{
  public int iItemId = -1;
  public int iType = 0;
  public String strCmShowActionId = "";
  public String strFullScreenUrl = "";
  
  public QzmallCustomPassivePraise() {}
  
  public QzmallCustomPassivePraise(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.iItemId = paramInt1;
    this.strFullScreenUrl = paramString1;
    this.iType = paramInt2;
    this.strCmShowActionId = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strFullScreenUrl = paramJceInputStream.readString(1, false);
    this.iType = paramJceInputStream.read(this.iType, 2, false);
    this.strCmShowActionId = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    if (this.strFullScreenUrl != null) {
      paramJceOutputStream.write(this.strFullScreenUrl, 1);
    }
    paramJceOutputStream.write(this.iType, 2);
    if (this.strCmShowActionId != null) {
      paramJceOutputStream.write(this.strCmShowActionId, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.QzmallCustomPassivePraise
 * JD-Core Version:    0.7.0.1
 */