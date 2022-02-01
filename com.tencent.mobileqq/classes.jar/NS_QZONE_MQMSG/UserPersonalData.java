package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class UserPersonalData
  extends JceStruct
{
  static Map<Long, UserPersonalProfile> cache_mpUinToProfile = new HashMap();
  public String bigVipJumpUrl = "";
  public String lJumpUrl = "";
  public Map<Long, UserPersonalProfile> mpUinToProfile = null;
  public String yJumpUrl = "";
  
  static
  {
    UserPersonalProfile localUserPersonalProfile = new UserPersonalProfile();
    cache_mpUinToProfile.put(Long.valueOf(0L), localUserPersonalProfile);
  }
  
  public UserPersonalData() {}
  
  public UserPersonalData(Map<Long, UserPersonalProfile> paramMap, String paramString1, String paramString2, String paramString3)
  {
    this.mpUinToProfile = paramMap;
    this.yJumpUrl = paramString1;
    this.lJumpUrl = paramString2;
    this.bigVipJumpUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mpUinToProfile = ((Map)paramJceInputStream.read(cache_mpUinToProfile, 0, false));
    this.yJumpUrl = paramJceInputStream.readString(1, false);
    this.lJumpUrl = paramJceInputStream.readString(2, false);
    this.bigVipJumpUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.mpUinToProfile != null) {
      paramJceOutputStream.write(this.mpUinToProfile, 0);
    }
    if (this.yJumpUrl != null) {
      paramJceOutputStream.write(this.yJumpUrl, 1);
    }
    if (this.lJumpUrl != null) {
      paramJceOutputStream.write(this.lJumpUrl, 2);
    }
    if (this.bigVipJumpUrl != null) {
      paramJceOutputStream.write(this.bigVipJumpUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.UserPersonalData
 * JD-Core Version:    0.7.0.1
 */