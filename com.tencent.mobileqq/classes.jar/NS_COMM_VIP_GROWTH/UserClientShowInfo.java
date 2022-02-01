package NS_COMM_VIP_GROWTH;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UserClientShowInfo
  extends JceStruct
{
  static Map<String, IconInfo> cache_mapIconInfo = new HashMap();
  public int iIsUseVipIcon = 0;
  public int iKeepVipDays = 0;
  public int iLevel = 0;
  public int iScore = 0;
  public int iSpeed = 0;
  public int iVip = 0;
  public int iVipRatio = 0;
  public Map<String, IconInfo> mapIconInfo = null;
  public String strUid = "";
  
  static
  {
    IconInfo localIconInfo = new IconInfo();
    cache_mapIconInfo.put("", localIconInfo);
  }
  
  public UserClientShowInfo() {}
  
  public UserClientShowInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, Map<String, IconInfo> paramMap)
  {
    this.strUid = paramString;
    this.iVipRatio = paramInt1;
    this.iKeepVipDays = paramInt2;
    this.iVip = paramInt3;
    this.iLevel = paramInt4;
    this.iSpeed = paramInt5;
    this.iScore = paramInt6;
    this.iIsUseVipIcon = paramInt7;
    this.mapIconInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strUid = paramJceInputStream.readString(0, false);
    this.iVipRatio = paramJceInputStream.read(this.iVipRatio, 1, false);
    this.iKeepVipDays = paramJceInputStream.read(this.iKeepVipDays, 2, false);
    this.iVip = paramJceInputStream.read(this.iVip, 3, false);
    this.iLevel = paramJceInputStream.read(this.iLevel, 4, false);
    this.iSpeed = paramJceInputStream.read(this.iSpeed, 5, false);
    this.iScore = paramJceInputStream.read(this.iScore, 6, false);
    this.iIsUseVipIcon = paramJceInputStream.read(this.iIsUseVipIcon, 7, false);
    this.mapIconInfo = ((Map)paramJceInputStream.read(cache_mapIconInfo, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.strUid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.iVipRatio, 1);
    paramJceOutputStream.write(this.iKeepVipDays, 2);
    paramJceOutputStream.write(this.iVip, 3);
    paramJceOutputStream.write(this.iLevel, 4);
    paramJceOutputStream.write(this.iSpeed, 5);
    paramJceOutputStream.write(this.iScore, 6);
    paramJceOutputStream.write(this.iIsUseVipIcon, 7);
    localObject = this.mapIconInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_COMM_VIP_GROWTH.UserClientShowInfo
 * JD-Core Version:    0.7.0.1
 */