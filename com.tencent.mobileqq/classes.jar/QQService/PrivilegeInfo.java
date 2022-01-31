package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PrivilegeInfo
  extends JceStruct
{
  public int iFeeType = -1;
  public int iFlag;
  public int iLevel = -1;
  public int iSort = -1;
  public int iType = -1;
  public String strDeluxeIconUrl = "";
  public String strIconUrl = "";
  
  public PrivilegeInfo() {}
  
  public PrivilegeInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2)
  {
    this.iType = paramInt1;
    this.iSort = paramInt2;
    this.iFeeType = paramInt3;
    this.iLevel = paramInt4;
    this.iFlag = paramInt5;
    this.strIconUrl = paramString1;
    this.strDeluxeIconUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, true);
    this.iSort = paramJceInputStream.read(this.iSort, 1, true);
    this.iFeeType = paramJceInputStream.read(this.iFeeType, 2, true);
    this.iLevel = paramJceInputStream.read(this.iLevel, 3, true);
    this.iFlag = paramJceInputStream.read(this.iFlag, 4, true);
    this.strIconUrl = paramJceInputStream.readString(5, false);
    this.strDeluxeIconUrl = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    paramJceOutputStream.write(this.iSort, 1);
    paramJceOutputStream.write(this.iFeeType, 2);
    paramJceOutputStream.write(this.iLevel, 3);
    paramJceOutputStream.write(this.iFlag, 4);
    if (this.strIconUrl != null) {
      paramJceOutputStream.write(this.strIconUrl, 5);
    }
    if (this.strDeluxeIconUrl != null) {
      paramJceOutputStream.write(this.strDeluxeIconUrl, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.PrivilegeInfo
 * JD-Core Version:    0.7.0.1
 */