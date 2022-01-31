package NS_MOBILE_BULLET_CURTAIN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class single_bullet
  extends JceStruct
{
  static Map<Integer, String> cache_background = new HashMap();
  public Map<Integer, String> background;
  public String content = "";
  public String jump_keyword = "";
  public String jump_schema = "";
  public int jump_type;
  public String nickname = "";
  public long uin;
  
  static
  {
    cache_background.put(Integer.valueOf(0), "");
  }
  
  public single_bullet() {}
  
  public single_bullet(long paramLong, String paramString1, String paramString2, Map<Integer, String> paramMap, int paramInt, String paramString3, String paramString4)
  {
    this.uin = paramLong;
    this.nickname = paramString1;
    this.content = paramString2;
    this.background = paramMap;
    this.jump_type = paramInt;
    this.jump_keyword = paramString3;
    this.jump_schema = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.content = paramJceInputStream.readString(2, false);
    this.background = ((Map)paramJceInputStream.read(cache_background, 3, false));
    this.jump_type = paramJceInputStream.read(this.jump_type, 4, false);
    this.jump_keyword = paramJceInputStream.readString(5, false);
    this.jump_schema = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 1);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    if (this.background != null) {
      paramJceOutputStream.write(this.background, 3);
    }
    paramJceOutputStream.write(this.jump_type, 4);
    if (this.jump_keyword != null) {
      paramJceOutputStream.write(this.jump_keyword, 5);
    }
    if (this.jump_schema != null) {
      paramJceOutputStream.write(this.jump_schema, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_BULLET_CURTAIN.single_bullet
 * JD-Core Version:    0.7.0.1
 */