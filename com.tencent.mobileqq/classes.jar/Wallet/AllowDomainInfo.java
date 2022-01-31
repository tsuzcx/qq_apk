package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AllowDomainInfo
  extends JceStruct
{
  public String allow_domain_regex = "";
  public int open_type;
  
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
    return "AllowDomainInfo{allow_domain_regex='" + this.allow_domain_regex + '\'' + ", open_type=" + this.open_type + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.allow_domain_regex != null) {
      paramJceOutputStream.write(this.allow_domain_regex, 0);
    }
    paramJceOutputStream.write(this.open_type, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.AllowDomainInfo
 * JD-Core Version:    0.7.0.1
 */