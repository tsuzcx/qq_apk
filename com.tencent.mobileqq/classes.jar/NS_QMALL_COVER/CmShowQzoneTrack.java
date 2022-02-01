package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class CmShowQzoneTrack
  extends JceStruct
{
  public int iItemType = 0;
  public String strItemId = "";
  public String strName = "";
  public String strThumb = "";
  
  public CmShowQzoneTrack() {}
  
  public CmShowQzoneTrack(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.strThumb = paramString1;
    this.iItemType = paramInt;
    this.strItemId = paramString2;
    this.strName = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strThumb = paramJceInputStream.readString(0, false);
    this.iItemType = paramJceInputStream.read(this.iItemType, 1, false);
    this.strItemId = paramJceInputStream.readString(2, false);
    this.strName = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strThumb != null) {
      paramJceOutputStream.write(this.strThumb, 0);
    }
    paramJceOutputStream.write(this.iItemType, 1);
    if (this.strItemId != null) {
      paramJceOutputStream.write(this.strItemId, 2);
    }
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QMALL_COVER.CmShowQzoneTrack
 * JD-Core Version:    0.7.0.1
 */