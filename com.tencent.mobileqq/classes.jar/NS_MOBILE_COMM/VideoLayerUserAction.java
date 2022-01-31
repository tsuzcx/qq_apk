package NS_MOBILE_COMM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class VideoLayerUserAction
  extends JceStruct
  implements Comparable<VideoLayerUserAction>
{
  public int appid;
  public boolean has_comment;
  public boolean has_follow;
  public boolean has_forward;
  public boolean has_like;
  public int index;
  public String mkey = "";
  public long video_duration;
  public int video_integrity;
  
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
    int k = 0;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = JceUtil.compareTo(this.index, paramVideoLayerUserAction.index);
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < arrayOfInt.length)
      {
        if (arrayOfInt[i] != 0) {
          j = arrayOfInt[i];
        }
      }
      else {
        return j;
      }
      i += 1;
    }
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
    if (this.mkey != null) {
      paramJceOutputStream.write(this.mkey, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_COMM.VideoLayerUserAction
 * JD-Core Version:    0.7.0.1
 */