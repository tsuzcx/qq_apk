package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MarkFaceInPhotoReq
  extends JceStruct
{
  static MarkFaceItemFeed cache_feed_face_info = new MarkFaceItemFeed();
  static MarkFaceItemMood cache_mood_face_info = new MarkFaceItemMood();
  static int cache_scene = 0;
  public MarkFaceItemFeed feed_face_info = null;
  public MarkFaceItemMood mood_face_info = null;
  public long owner = 0L;
  public int scene = 0;
  
  public MarkFaceInPhotoReq() {}
  
  public MarkFaceInPhotoReq(long paramLong, int paramInt, MarkFaceItemFeed paramMarkFaceItemFeed, MarkFaceItemMood paramMarkFaceItemMood)
  {
    this.owner = paramLong;
    this.scene = paramInt;
    this.feed_face_info = paramMarkFaceItemFeed;
    this.mood_face_info = paramMarkFaceItemMood;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.owner = paramJceInputStream.read(this.owner, 0, false);
    this.scene = paramJceInputStream.read(this.scene, 1, false);
    this.feed_face_info = ((MarkFaceItemFeed)paramJceInputStream.read(cache_feed_face_info, 2, false));
    this.mood_face_info = ((MarkFaceItemMood)paramJceInputStream.read(cache_mood_face_info, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.owner, 0);
    paramJceOutputStream.write(this.scene, 1);
    if (this.feed_face_info != null) {
      paramJceOutputStream.write(this.feed_face_info, 2);
    }
    if (this.mood_face_info != null) {
      paramJceOutputStream.write(this.mood_face_info, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.MarkFaceInPhotoReq
 * JD-Core Version:    0.7.0.1
 */