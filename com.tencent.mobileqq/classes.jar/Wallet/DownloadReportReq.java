package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class DownloadReportReq
  extends JceStruct
{
  public static final int TYPE_DOWNLOADING = 0;
  public static final int TYPE_DOWNLOAD_FAIL = 2;
  public static final int TYPE_DOWNLOAD_SUCC = 1;
  static ArrayList<ResInfo> cache_vecResInfo = new ArrayList();
  public int iActId = 1001;
  public int iPlatForm = 1;
  public int iScene = 0;
  public int iType = 0;
  public long iUin = 0L;
  public String sOsVersion = "";
  public String sPhoneType = "";
  public String sQQVersion = "";
  public String sSpeed = "";
  public ArrayList<ResInfo> vecResInfo = null;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DownRep{iType=");
    localStringBuilder.append(this.iType);
    localStringBuilder.append("iScene =");
    localStringBuilder.append(this.iScene);
    localStringBuilder.append("vecResInfo = ");
    localStringBuilder.append(this.vecResInfo);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sPhoneType);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sOsVersion);
    localStringBuilder.append("|");
    localStringBuilder.append(this.sQQVersion);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iActId, 0);
    paramJceOutputStream.write(this.iType, 1);
    Object localObject = this.vecResInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    paramJceOutputStream.write(this.iUin, 3);
    localObject = this.sSpeed;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.iPlatForm, 5);
    paramJceOutputStream.write(this.iScene, 6);
    localObject = this.sPhoneType;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.sOsVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.sQQVersion;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.DownloadReportReq
 * JD-Core Version:    0.7.0.1
 */