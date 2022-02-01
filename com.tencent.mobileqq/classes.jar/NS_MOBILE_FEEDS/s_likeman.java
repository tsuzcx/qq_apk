package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_likeman
  extends JceStruct
{
  static s_PolyPraise cache_cpolyPraise = new s_PolyPraise();
  static s_CustomPraise cache_customPraise;
  static s_user cache_user = new s_user();
  public s_PolyPraise cpolyPraise = null;
  public s_CustomPraise customPraise = null;
  public String refer = "";
  public int superflag = 0;
  public s_user user = null;
  
  static
  {
    cache_customPraise = new s_CustomPraise();
  }
  
  public s_likeman() {}
  
  public s_likeman(s_user params_user, String paramString, int paramInt, s_CustomPraise params_CustomPraise, s_PolyPraise params_PolyPraise)
  {
    this.user = params_user;
    this.refer = paramString;
    this.superflag = paramInt;
    this.customPraise = params_CustomPraise;
    this.cpolyPraise = params_PolyPraise;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.user = ((s_user)paramJceInputStream.read(cache_user, 0, false));
    this.refer = paramJceInputStream.readString(1, false);
    this.superflag = paramJceInputStream.read(this.superflag, 2, false);
    this.customPraise = ((s_CustomPraise)paramJceInputStream.read(cache_customPraise, 3, false));
    this.cpolyPraise = ((s_PolyPraise)paramJceInputStream.read(cache_cpolyPraise, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.user;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.refer;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.superflag, 2);
    localObject = this.customPraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.cpolyPraise;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_likeman
 * JD-Core Version:    0.7.0.1
 */