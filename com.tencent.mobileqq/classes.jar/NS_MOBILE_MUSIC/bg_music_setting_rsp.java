package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class bg_music_setting_rsp
  extends JceStruct
{
  public int ret_code;
  
  public bg_music_setting_rsp() {}
  
  public bg_music_setting_rsp(int paramInt)
  {
    this.ret_code = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret_code = paramJceInputStream.read(this.ret_code, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret_code, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MUSIC.bg_music_setting_rsp
 * JD-Core Version:    0.7.0.1
 */