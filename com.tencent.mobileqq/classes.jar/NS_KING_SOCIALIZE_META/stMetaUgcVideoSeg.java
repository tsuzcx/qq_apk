package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaUgcVideoSeg
  extends JceStruct
{
  static stMetaLoudNorm cache_meta_loudnorm = new stMetaLoudNorm();
  public int duration;
  public String file_id = "";
  public int file_size;
  public int h265_hvc1;
  public int height;
  public String loudnorm = "";
  public int max_db;
  public String md5 = "";
  public stMetaLoudNorm meta_loudnorm;
  public int orientation;
  public int play_index;
  public String sha1 = "";
  public double voice_ratio;
  public int width;
  
  public stMetaUgcVideoSeg() {}
  
  public stMetaUgcVideoSeg(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString3, int paramInt6, int paramInt7, int paramInt8, double paramDouble, String paramString4, stMetaLoudNorm paramstMetaLoudNorm)
  {
    this.file_id = paramString1;
    this.file_size = paramInt1;
    this.sha1 = paramString2;
    this.play_index = paramInt2;
    this.duration = paramInt3;
    this.width = paramInt4;
    this.height = paramInt5;
    this.md5 = paramString3;
    this.orientation = paramInt6;
    this.h265_hvc1 = paramInt7;
    this.max_db = paramInt8;
    this.voice_ratio = paramDouble;
    this.loudnorm = paramString4;
    this.meta_loudnorm = paramstMetaLoudNorm;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.file_id = paramJceInputStream.readString(0, false);
    this.file_size = paramJceInputStream.read(this.file_size, 1, false);
    this.sha1 = paramJceInputStream.readString(2, false);
    this.play_index = paramJceInputStream.read(this.play_index, 3, false);
    this.duration = paramJceInputStream.read(this.duration, 4, false);
    this.width = paramJceInputStream.read(this.width, 5, false);
    this.height = paramJceInputStream.read(this.height, 6, false);
    this.md5 = paramJceInputStream.readString(7, false);
    this.orientation = paramJceInputStream.read(this.orientation, 8, false);
    this.h265_hvc1 = paramJceInputStream.read(this.h265_hvc1, 9, false);
    this.max_db = paramJceInputStream.read(this.max_db, 10, false);
    this.voice_ratio = paramJceInputStream.read(this.voice_ratio, 11, false);
    this.loudnorm = paramJceInputStream.readString(12, false);
    this.meta_loudnorm = ((stMetaLoudNorm)paramJceInputStream.read(cache_meta_loudnorm, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.file_id != null) {
      paramJceOutputStream.write(this.file_id, 0);
    }
    paramJceOutputStream.write(this.file_size, 1);
    if (this.sha1 != null) {
      paramJceOutputStream.write(this.sha1, 2);
    }
    paramJceOutputStream.write(this.play_index, 3);
    paramJceOutputStream.write(this.duration, 4);
    paramJceOutputStream.write(this.width, 5);
    paramJceOutputStream.write(this.height, 6);
    if (this.md5 != null) {
      paramJceOutputStream.write(this.md5, 7);
    }
    paramJceOutputStream.write(this.orientation, 8);
    paramJceOutputStream.write(this.h265_hvc1, 9);
    paramJceOutputStream.write(this.max_db, 10);
    paramJceOutputStream.write(this.voice_ratio, 11);
    if (this.loudnorm != null) {
      paramJceOutputStream.write(this.loudnorm, 12);
    }
    if (this.meta_loudnorm != null) {
      paramJceOutputStream.write(this.meta_loudnorm, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg
 * JD-Core Version:    0.7.0.1
 */