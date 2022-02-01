package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PrivilegeInfo
  extends JceStruct
{
  public int iFeeType = -1;
  public int iFlag = 0;
  public int iIsBig = 0;
  public int iIsRemind = 0;
  public int iLevel = -1;
  public int iRemindTime = 0;
  public int iSort = -1;
  public int iTipsTimes = 0;
  public int iType = -1;
  public boolean isOpen = false;
  public String strDeluxeIconUrl = "";
  public String strIconUrl = "";
  public String strJumpUrl = "";
  public String strTipsIconUrl = "";
  
  public PrivilegeInfo() {}
  
  public PrivilegeInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString1, String paramString2, String paramString3, int paramInt6, int paramInt7, int paramInt8, String paramString4, int paramInt9)
  {
    this.iType = paramInt1;
    this.iSort = paramInt2;
    this.iFeeType = paramInt3;
    this.iLevel = paramInt4;
    this.iFlag = paramInt5;
    this.strIconUrl = paramString1;
    this.strDeluxeIconUrl = paramString2;
    this.strJumpUrl = paramString3;
    this.iIsBig = paramInt6;
    this.iIsRemind = paramInt7;
    this.iRemindTime = paramInt8;
    this.strTipsIconUrl = paramString4;
    this.iTipsTimes = paramInt9;
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
    this.strJumpUrl = paramJceInputStream.readString(7, false);
    this.iIsBig = paramJceInputStream.read(this.iIsBig, 8, false);
    this.iIsRemind = paramJceInputStream.read(this.iIsRemind, 9, false);
    this.iRemindTime = paramJceInputStream.read(this.iRemindTime, 10, false);
    this.strTipsIconUrl = paramJceInputStream.readString(11, false);
    this.iTipsTimes = paramJceInputStream.read(this.iTipsTimes, 12, false);
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
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 7);
    }
    paramJceOutputStream.write(this.iIsBig, 8);
    paramJceOutputStream.write(this.iIsRemind, 9);
    paramJceOutputStream.write(this.iRemindTime, 10);
    paramJceOutputStream.write(this.strTipsIconUrl, 11);
    paramJceOutputStream.write(this.iTipsTimes, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.PrivilegeInfo
 * JD-Core Version:    0.7.0.1
 */