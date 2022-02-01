package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAllBgMusicListRsp
  extends JceStruct
{
  static ArrayList<MusicInfo> cache_all_music_list;
  public ArrayList<MusicInfo> all_music_list;
  public int all_music_nums;
  public byte green_diamond_flag;
  public boolean music_can_play = true;
  public byte play_mode_flag;
  public byte wifi_auto_play;
  
  public GetAllBgMusicListRsp() {}
  
  public GetAllBgMusicListRsp(byte paramByte1, boolean paramBoolean, int paramInt, ArrayList<MusicInfo> paramArrayList, byte paramByte2, byte paramByte3)
  {
    this.green_diamond_flag = paramByte1;
    this.music_can_play = paramBoolean;
    this.all_music_nums = paramInt;
    this.all_music_list = paramArrayList;
    this.wifi_auto_play = paramByte2;
    this.play_mode_flag = paramByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.green_diamond_flag = paramJceInputStream.read(this.green_diamond_flag, 0, false);
    this.music_can_play = paramJceInputStream.read(this.music_can_play, 1, false);
    this.all_music_nums = paramJceInputStream.read(this.all_music_nums, 2, false);
    if (cache_all_music_list == null)
    {
      cache_all_music_list = new ArrayList();
      MusicInfo localMusicInfo = new MusicInfo();
      cache_all_music_list.add(localMusicInfo);
    }
    this.all_music_list = ((ArrayList)paramJceInputStream.read(cache_all_music_list, 3, false));
    this.wifi_auto_play = paramJceInputStream.read(this.wifi_auto_play, 4, false);
    this.play_mode_flag = paramJceInputStream.read(this.play_mode_flag, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.green_diamond_flag, 0);
    paramJceOutputStream.write(this.music_can_play, 1);
    paramJceOutputStream.write(this.all_music_nums, 2);
    ArrayList localArrayList = this.all_music_list;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 3);
    }
    paramJceOutputStream.write(this.wifi_auto_play, 4);
    paramJceOutputStream.write(this.play_mode_flag, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MUSIC.GetAllBgMusicListRsp
 * JD-Core Version:    0.7.0.1
 */