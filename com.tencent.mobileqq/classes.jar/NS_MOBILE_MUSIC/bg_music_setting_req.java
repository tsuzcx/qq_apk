package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class bg_music_setting_req
  extends JceStruct
{
  public int setting_type;
  public int setting_value;
  public long uin;
  
  public bg_music_setting_req() {}
  
  public bg_music_setting_req(long paramLong, int paramInt1, int paramInt2)
  {
    this.uin = paramLong;
    this.setting_type = paramInt1;
    this.setting_value = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.setting_type = paramJceInputStream.read(this.setting_type, 1, true);
    this.setting_value = paramJceInputStream.read(this.setting_value, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.setting_type, 1);
    paramJceOutputStream.write(this.setting_value, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MUSIC.bg_music_setting_req
 * JD-Core Version:    0.7.0.1
 */