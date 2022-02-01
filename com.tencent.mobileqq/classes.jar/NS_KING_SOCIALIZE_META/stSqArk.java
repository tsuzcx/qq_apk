package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSqArk
  extends JceStruct
{
  static stShareBody cache_shareBody = new stShareBody();
  public String arkData = "";
  public String coverProto = "";
  public stShareBody shareBody = null;
  
  public stSqArk() {}
  
  public stSqArk(String paramString1, stShareBody paramstShareBody, String paramString2)
  {
    this.arkData = paramString1;
    this.shareBody = paramstShareBody;
    this.coverProto = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.arkData = paramJceInputStream.readString(0, false);
    this.shareBody = ((stShareBody)paramJceInputStream.read(cache_shareBody, 1, false));
    this.coverProto = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.arkData;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.shareBody;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.coverProto;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stSqArk
 * JD-Core Version:    0.7.0.1
 */