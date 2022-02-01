package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMusicFullInfo
  extends JceStruct
{
  static stAlbumInfo cache_albumInfo = new stAlbumInfo();
  static stConfInfo cache_confInfo;
  static stLyricInfo cache_foreignlyric = new stLyricInfo();
  static stLyricInfo cache_lyricInfo;
  static stSingerInfo cache_singerInfo = new stSingerInfo();
  static stSongInfo cache_songInfo = new stSongInfo();
  static stLyricInfo cache_subtitleInfo;
  public stAlbumInfo albumInfo = null;
  public stConfInfo confInfo = null;
  public stLyricInfo foreignlyric = null;
  public stLyricInfo lyricInfo = null;
  public stSingerInfo singerInfo = null;
  public stSongInfo songInfo = null;
  public stLyricInfo subtitleInfo = null;
  
  static
  {
    cache_lyricInfo = new stLyricInfo();
    cache_confInfo = new stConfInfo();
    cache_subtitleInfo = new stLyricInfo();
  }
  
  public stMusicFullInfo() {}
  
  public stMusicFullInfo(stAlbumInfo paramstAlbumInfo, stSingerInfo paramstSingerInfo, stSongInfo paramstSongInfo, stLyricInfo paramstLyricInfo1, stConfInfo paramstConfInfo, stLyricInfo paramstLyricInfo2, stLyricInfo paramstLyricInfo3)
  {
    this.albumInfo = paramstAlbumInfo;
    this.singerInfo = paramstSingerInfo;
    this.songInfo = paramstSongInfo;
    this.lyricInfo = paramstLyricInfo1;
    this.confInfo = paramstConfInfo;
    this.subtitleInfo = paramstLyricInfo2;
    this.foreignlyric = paramstLyricInfo3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumInfo = ((stAlbumInfo)paramJceInputStream.read(cache_albumInfo, 0, false));
    this.singerInfo = ((stSingerInfo)paramJceInputStream.read(cache_singerInfo, 1, false));
    this.songInfo = ((stSongInfo)paramJceInputStream.read(cache_songInfo, 2, false));
    this.lyricInfo = ((stLyricInfo)paramJceInputStream.read(cache_lyricInfo, 3, false));
    this.confInfo = ((stConfInfo)paramJceInputStream.read(cache_confInfo, 4, false));
    this.subtitleInfo = ((stLyricInfo)paramJceInputStream.read(cache_subtitleInfo, 5, false));
    this.foreignlyric = ((stLyricInfo)paramJceInputStream.read(cache_foreignlyric, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumInfo != null) {
      paramJceOutputStream.write(this.albumInfo, 0);
    }
    if (this.singerInfo != null) {
      paramJceOutputStream.write(this.singerInfo, 1);
    }
    if (this.songInfo != null) {
      paramJceOutputStream.write(this.songInfo, 2);
    }
    if (this.lyricInfo != null) {
      paramJceOutputStream.write(this.lyricInfo, 3);
    }
    if (this.confInfo != null) {
      paramJceOutputStream.write(this.confInfo, 4);
    }
    if (this.subtitleInfo != null) {
      paramJceOutputStream.write(this.subtitleInfo, 5);
    }
    if (this.foreignlyric != null) {
      paramJceOutputStream.write(this.foreignlyric, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMusicFullInfo
 * JD-Core Version:    0.7.0.1
 */