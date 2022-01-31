package NS_MOBILE_COVER_DATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MoodEntryContent
  extends JceStruct
{
  public String content = "";
  
  public MoodEntryContent() {}
  
  public MoodEntryContent(String paramString)
  {
    this.content = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.content = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_COVER_DATE.MoodEntryContent
 * JD-Core Version:    0.7.0.1
 */