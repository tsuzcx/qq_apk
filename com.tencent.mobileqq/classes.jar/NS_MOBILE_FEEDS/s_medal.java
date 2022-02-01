package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_medal
  extends JceStruct
{
  static int cache_medal_state = 0;
  static int cache_medal_type = 0;
  public String jump_url = "";
  public int level = 0;
  public int medal_id = 0;
  public int medal_state = 0;
  public int medal_type = 0;
  public String pic_url = "";
  
  public s_medal() {}
  
  public s_medal(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4)
  {
    this.medal_type = paramInt1;
    this.medal_state = paramInt2;
    this.level = paramInt3;
    this.pic_url = paramString1;
    this.jump_url = paramString2;
    this.medal_id = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.medal_type = paramJceInputStream.read(this.medal_type, 0, false);
    this.medal_state = paramJceInputStream.read(this.medal_state, 1, false);
    this.level = paramJceInputStream.read(this.level, 2, false);
    this.pic_url = paramJceInputStream.readString(3, false);
    this.jump_url = paramJceInputStream.readString(4, false);
    this.medal_id = paramJceInputStream.read(this.medal_id, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.medal_type, 0);
    paramJceOutputStream.write(this.medal_state, 1);
    paramJceOutputStream.write(this.level, 2);
    if (this.pic_url != null) {
      paramJceOutputStream.write(this.pic_url, 3);
    }
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 4);
    }
    paramJceOutputStream.write(this.medal_id, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_medal
 * JD-Core Version:    0.7.0.1
 */