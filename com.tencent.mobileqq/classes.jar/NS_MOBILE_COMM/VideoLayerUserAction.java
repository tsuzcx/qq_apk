package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class VideoLayerUserAction
  extends JceStruct
  implements Comparable<VideoLayerUserAction>
{
  public int appid = 0;
  public boolean has_comment = false;
  public boolean has_follow = false;
  public boolean has_forward = false;
  public boolean has_like = false;
  public int index = 0;
  public String mkey = "";
  public long video_duration = 0L;
  public int video_integrity = 0;
  
  public VideoLayerUserAction() {}
  
  public VideoLayerUserAction(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    this.index = paramInt1;
    this.appid = paramInt2;
    this.video_integrity = paramInt3;
    this.video_duration = paramLong;
    this.has_like = paramBoolean1;
    this.has_comment = paramBoolean2;
    this.has_forward = paramBoolean3;
    this.has_follow = paramBoolean4;
    this.mkey = paramString;
  }
  
  public int compareTo(VideoLayerUserAction paramVideoLayerUserAction)
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = JceUtil.compareTo(this.index, paramVideoLayerUserAction.index);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      if (arrayOfInt[i] != 0) {
        return arrayOfInt[i];
      }
      i += 1;
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.index = paramJceInputStream.read(this.index, 0, false);
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.video_integrity = paramJceInputStream.read(this.video_integrity, 2, false);
    this.video_duration = paramJceInputStream.read(this.video_duration, 3, false);
    this.has_like = paramJceInputStream.read(this.has_like, 4, false);
    this.has_comment = paramJceInputStream.read(this.has_comment, 5, false);
    this.has_forward = paramJceInputStream.read(this.has_forward, 6, false);
    this.has_follow = paramJceInputStream.read(this.has_follow, 7, false);
    this.mkey = paramJceInputStream.readString(8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.index, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.video_integrity, 2);
    paramJceOutputStream.write(this.video_duration, 3);
    paramJceOutputStream.write(this.has_like, 4);
    paramJceOutputStream.write(this.has_comment, 5);
    paramJceOutputStream.write(this.has_forward, 6);
    paramJceOutputStream.write(this.has_follow, 7);
    String str = this.mkey;
    if (str != null) {
      paramJceOutputStream.write(str, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_COMM.VideoLayerUserAction
 * JD-Core Version:    0.7.0.1
 */