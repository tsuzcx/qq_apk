package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaTag
  extends JceStruct
{
  public String iconUrl = "";
  public String jumpurl = "";
  public int tag_type = 0;
  public String title = "";
  
  public stMetaTag() {}
  
  public stMetaTag(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.title = paramString1;
    this.jumpurl = paramString2;
    this.tag_type = paramInt;
    this.iconUrl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.jumpurl = paramJceInputStream.readString(1, false);
    this.tag_type = paramJceInputStream.read(this.tag_type, 2, false);
    this.iconUrl = paramJceInputStream.readString(3, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{title='");
    localStringBuilder.append(this.title);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpurl='");
    localStringBuilder.append(this.jumpurl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tag_type=");
    localStringBuilder.append(this.tag_type);
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.title;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.jumpurl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.tag_type, 2);
    str = this.iconUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaTag
 * JD-Core Version:    0.7.0.1
 */