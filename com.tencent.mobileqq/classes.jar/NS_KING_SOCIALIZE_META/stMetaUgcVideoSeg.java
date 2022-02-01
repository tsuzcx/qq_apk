package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMetaUgcVideoSeg
  extends JceStruct
{
  static stMetaLoudNorm cache_meta_loudnorm = new stMetaLoudNorm();
  public int duration = 0;
  public String file_id = "";
  public int file_size = 0;
  public int h265_hvc1 = 0;
  public int height = 0;
  public String loudnorm = "";
  public int max_db = 0;
  public String md5 = "";
  public stMetaLoudNorm meta_loudnorm = null;
  public int orientation = 0;
  public int play_index = 0;
  public String sha1 = "";
  public double voice_ratio = 0.0D;
  public int width = 0;
  
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
    Object localObject = this.file_id;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.file_size, 1);
    localObject = this.sha1;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.play_index, 3);
    paramJceOutputStream.write(this.duration, 4);
    paramJceOutputStream.write(this.width, 5);
    paramJceOutputStream.write(this.height, 6);
    localObject = this.md5;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.orientation, 8);
    paramJceOutputStream.write(this.h265_hvc1, 9);
    paramJceOutputStream.write(this.max_db, 10);
    paramJceOutputStream.write(this.voice_ratio, 11);
    localObject = this.loudnorm;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.meta_loudnorm;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg
 * JD-Core Version:    0.7.0.1
 */