package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PayRuleCfg
  extends JceStruct
{
  static ShowRule cache_rule = new ShowRule();
  public String advId = "";
  public String aid = "";
  public int clickHide = 0;
  public int clubType = 0;
  public int enable = 0;
  public String iconJumpUrl = "";
  public String iconText = "";
  public String iconTextCol = "";
  public String iconUrl = "";
  public String iosAid = "";
  public int payHide = 0;
  public ShowRule rule = null;
  public int update = 0;
  public int userType = 0;
  
  public PayRuleCfg() {}
  
  public PayRuleCfg(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, ShowRule paramShowRule, String paramString5, String paramString6, String paramString7, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.enable = paramInt1;
    this.aid = paramString1;
    this.iconText = paramString2;
    this.iconUrl = paramString3;
    this.iconJumpUrl = paramString4;
    this.rule = paramShowRule;
    this.advId = paramString5;
    this.iconTextCol = paramString6;
    this.iosAid = paramString7;
    this.update = paramInt2;
    this.userType = paramInt3;
    this.clubType = paramInt4;
    this.clickHide = paramInt5;
    this.payHide = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.enable = paramJceInputStream.read(this.enable, 0, false);
    this.aid = paramJceInputStream.readString(1, false);
    this.iconText = paramJceInputStream.readString(2, false);
    this.iconUrl = paramJceInputStream.readString(3, false);
    this.iconJumpUrl = paramJceInputStream.readString(4, false);
    this.rule = ((ShowRule)paramJceInputStream.read(cache_rule, 5, false));
    this.advId = paramJceInputStream.readString(6, false);
    this.iconTextCol = paramJceInputStream.readString(7, false);
    this.iosAid = paramJceInputStream.readString(8, false);
    this.update = paramJceInputStream.read(this.update, 9, false);
    this.userType = paramJceInputStream.read(this.userType, 10, false);
    this.clubType = paramJceInputStream.read(this.clubType, 11, false);
    this.clickHide = paramJceInputStream.read(this.clickHide, 12, false);
    this.payHide = paramJceInputStream.read(this.payHide, 13, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PayRuleCfg{enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", aid='");
    localStringBuilder.append(this.aid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconText='");
    localStringBuilder.append(this.iconText);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconJumpUrl='");
    localStringBuilder.append(this.iconJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rule=");
    localStringBuilder.append(this.rule);
    localStringBuilder.append(", advId='");
    localStringBuilder.append(this.advId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconTextCol='");
    localStringBuilder.append(this.iconTextCol);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iosAid='");
    localStringBuilder.append(this.iosAid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", update=");
    localStringBuilder.append(this.update);
    localStringBuilder.append(", userType=");
    localStringBuilder.append(this.userType);
    localStringBuilder.append(", clubType=");
    localStringBuilder.append(this.clubType);
    localStringBuilder.append(", clickHide=");
    localStringBuilder.append(this.clickHide);
    localStringBuilder.append(", payHide=");
    localStringBuilder.append(this.payHide);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.enable, 0);
    Object localObject = this.aid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.iconText;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.iconUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.iconJumpUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.rule;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.advId;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.iconTextCol;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.iosAid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.update, 9);
    paramJceOutputStream.write(this.userType, 10);
    paramJceOutputStream.write(this.clubType, 11);
    paramJceOutputStream.write(this.clickHide, 12);
    paramJceOutputStream.write(this.payHide, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.PayRuleCfg
 * JD-Core Version:    0.7.0.1
 */