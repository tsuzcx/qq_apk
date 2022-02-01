package NS_BG_VOICE_LOGIC_APP;

import NS_MOBILE_MUSIC.MusicInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BGMusic
  extends JceStruct
{
  static ArrayList<MusicInfo> cache_all_music_list = new ArrayList();
  public ArrayList<MusicInfo> all_music_list = null;
  public int all_music_nums = 0;
  public byte green_diamond_flag = 0;
  public boolean music_can_play = true;
  
  static
  {
    MusicInfo localMusicInfo = new MusicInfo();
    cache_all_music_list.add(localMusicInfo);
  }
  
  public BGMusic() {}
  
  public BGMusic(byte paramByte, boolean paramBoolean, int paramInt, ArrayList<MusicInfo> paramArrayList)
  {
    this.green_diamond_flag = paramByte;
    this.music_can_play = paramBoolean;
    this.all_music_nums = paramInt;
    this.all_music_list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.green_diamond_flag = paramJceInputStream.read(this.green_diamond_flag, 1, false);
    this.music_can_play = paramJceInputStream.read(this.music_can_play, 2, false);
    this.all_music_nums = paramJceInputStream.read(this.all_music_nums, 3, false);
    this.all_music_list = ((ArrayList)paramJceInputStream.read(cache_all_music_list, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.green_diamond_flag, 1);
    paramJceOutputStream.write(this.music_can_play, 2);
    paramJceOutputStream.write(this.all_music_nums, 3);
    ArrayList localArrayList = this.all_music_list;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_BG_VOICE_LOGIC_APP.BGMusic
 * JD-Core Version:    0.7.0.1
 */