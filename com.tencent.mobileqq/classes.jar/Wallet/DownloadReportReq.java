package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class DownloadReportReq
  extends JceStruct
{
  public static final int TYPE_DOWNLOADING = 0;
  public static final int TYPE_DOWNLOAD_FAIL = 2;
  public static final int TYPE_DOWNLOAD_SUCC = 1;
  static ArrayList cache_vecResInfo = new ArrayList();
  public int iActId = 1001;
  public int iPlatForm = 1;
  public int iScene;
  public int iType;
  public long iUin;
  public String sOsVersion = "";
  public String sPhoneType = "";
  public String sQQVersion = "";
  public String sSpeed = "";
  public ArrayList vecResInfo;
  
  static
  {
    ResInfo localResInfo = new ResInfo();
    cache_vecResInfo.add(localResInfo);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iActId = paramJceInputStream.read(this.iActId, 0, false);
    this.iType = paramJceInputStream.read(this.iType, 1, false);
    this.vecResInfo = ((ArrayList)paramJceInputStream.read(cache_vecResInfo, 2, false));
    this.iUin = paramJceInputStream.read(this.iUin, 3, false);
    this.sSpeed = paramJceInputStream.readString(4, false);
    this.iPlatForm = paramJceInputStream.read(this.iPlatForm, 5, false);
    this.iScene = paramJceInputStream.read(this.iScene, 6, false);
    this.sPhoneType = paramJceInputStream.readString(7, false);
    this.sOsVersion = paramJceInputStream.readString(8, false);
    this.sQQVersion = paramJceInputStream.readString(9, false);
  }
  
  public String toString()
  {
    return "DownRep{iType=" + this.iType + "iScene =" + this.iScene + "vecResInfo = " + this.vecResInfo + "|" + this.sPhoneType + "|" + this.sOsVersion + "|" + this.sQQVersion + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iActId, 0);
    paramJceOutputStream.write(this.iType, 1);
    if (this.vecResInfo != null) {
      paramJceOutputStream.write(this.vecResInfo, 2);
    }
    paramJceOutputStream.write(this.iUin, 3);
    if (this.sSpeed != null) {
      paramJceOutputStream.write(this.sSpeed, 4);
    }
    paramJceOutputStream.write(this.iPlatForm, 5);
    paramJceOutputStream.write(this.iScene, 6);
    if (this.sPhoneType != null) {
      paramJceOutputStream.write(this.sPhoneType, 7);
    }
    if (this.sOsVersion != null) {
      paramJceOutputStream.write(this.sOsVersion, 8);
    }
    if (this.sQQVersion != null) {
      paramJceOutputStream.write(this.sQQVersion, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     Wallet.DownloadReportReq
 * JD-Core Version:    0.7.0.1
 */