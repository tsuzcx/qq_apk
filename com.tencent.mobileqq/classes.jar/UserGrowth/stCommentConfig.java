package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stCommentConfig
  extends JceStruct
{
  public String guideText = "";
  
  public stCommentConfig() {}
  
  public stCommentConfig(String paramString)
  {
    this.guideText = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.guideText = paramJceInputStream.readString(0, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stCommentConfig{guideText='");
    localStringBuilder.append(this.guideText);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.guideText;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stCommentConfig
 * JD-Core Version:    0.7.0.1
 */