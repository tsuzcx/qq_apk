package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserFacadeInfo
  extends JceStruct
{
  static UserFacadeElementDetail cache_detail = new UserFacadeElementDetail();
  public String checksum = "";
  public int code = 0;
  public UserFacadeElementDetail detail = null;
  public String id = "";
  public String layout = "";
  public int switchStatus = 0;
  
  public UserFacadeInfo() {}
  
  public UserFacadeInfo(int paramInt1, String paramString1, String paramString2, UserFacadeElementDetail paramUserFacadeElementDetail, int paramInt2, String paramString3)
  {
    this.code = paramInt1;
    this.layout = paramString1;
    this.checksum = paramString2;
    this.detail = paramUserFacadeElementDetail;
    this.switchStatus = paramInt2;
    this.id = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.code = paramJceInputStream.read(this.code, 0, false);
    this.layout = paramJceInputStream.readString(1, false);
    this.checksum = paramJceInputStream.readString(2, false);
    this.detail = ((UserFacadeElementDetail)paramJceInputStream.read(cache_detail, 3, false));
    this.switchStatus = paramJceInputStream.read(this.switchStatus, 4, false);
    this.id = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.code, 0);
    Object localObject = this.layout;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.checksum;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.detail;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    paramJceOutputStream.write(this.switchStatus, 4);
    localObject = this.id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FACADE_DIY.UserFacadeInfo
 * JD-Core Version:    0.7.0.1
 */