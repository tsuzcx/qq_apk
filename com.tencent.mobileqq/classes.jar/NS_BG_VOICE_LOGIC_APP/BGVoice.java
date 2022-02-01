package NS_BG_VOICE_LOGIC_APP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BGVoice
  extends JceStruct
{
  static BGFM cache_bgFmLists = new BGFM();
  static BGMusic cache_bgMusicLists = new BGMusic();
  static int cache_iTypeValue;
  public BGFM bgFmLists = null;
  public BGMusic bgMusicLists = null;
  public int iTypeValue = 0;
  
  public BGVoice() {}
  
  public BGVoice(int paramInt, BGFM paramBGFM, BGMusic paramBGMusic)
  {
    this.iTypeValue = paramInt;
    this.bgFmLists = paramBGFM;
    this.bgMusicLists = paramBGMusic;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTypeValue = paramJceInputStream.read(this.iTypeValue, 0, false);
    this.bgFmLists = ((BGFM)paramJceInputStream.read(cache_bgFmLists, 1, false));
    this.bgMusicLists = ((BGMusic)paramJceInputStream.read(cache_bgMusicLists, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTypeValue, 0);
    Object localObject = this.bgFmLists;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.bgMusicLists;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_BG_VOICE_LOGIC_APP.BGVoice
 * JD-Core Version:    0.7.0.1
 */