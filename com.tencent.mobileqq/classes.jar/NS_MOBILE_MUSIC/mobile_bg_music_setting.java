package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_bg_music_setting
  extends JceStruct
{
  public byte loop_playback_flag = 0;
  public byte wifi_autu_play_flag = 0;
  
  public mobile_bg_music_setting() {}
  
  public mobile_bg_music_setting(byte paramByte1, byte paramByte2)
  {
    this.wifi_autu_play_flag = paramByte1;
    this.loop_playback_flag = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wifi_autu_play_flag = paramJceInputStream.read(this.wifi_autu_play_flag, 0, true);
    this.loop_playback_flag = paramJceInputStream.read(this.loop_playback_flag, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wifi_autu_play_flag, 0);
    paramJceOutputStream.write(this.loop_playback_flag, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MUSIC.mobile_bg_music_setting
 * JD-Core Version:    0.7.0.1
 */