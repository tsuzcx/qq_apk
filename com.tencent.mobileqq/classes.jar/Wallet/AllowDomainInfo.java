package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AllowDomainInfo
  extends JceStruct
{
  public String allow_domain_regex = "";
  public int open_type = 0;
  
  public AllowDomainInfo() {}
  
  public AllowDomainInfo(String paramString, int paramInt)
  {
    this.allow_domain_regex = paramString;
    this.open_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.allow_domain_regex = paramJceInputStream.readString(0, false);
    this.open_type = paramJceInputStream.read(this.open_type, 1, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AllowDomainInfo{allow_domain_regex='");
    localStringBuilder.append(this.allow_domain_regex);
    localStringBuilder.append('\'');
    localStringBuilder.append(", open_type=");
    localStringBuilder.append(this.open_type);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.allow_domain_regex;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.open_type, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.AllowDomainInfo
 * JD-Core Version:    0.7.0.1
 */