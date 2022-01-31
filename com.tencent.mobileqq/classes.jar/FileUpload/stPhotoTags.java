package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stPhotoTags
  extends JceStruct
{
  static ArrayList<stPhotoTag> cache_photoTag = new ArrayList();
  public ArrayList<stPhotoTag> photoTag = null;
  
  static
  {
    stPhotoTag localstPhotoTag = new stPhotoTag();
    cache_photoTag.add(localstPhotoTag);
  }
  
  public stPhotoTags() {}
  
  public stPhotoTags(ArrayList<stPhotoTag> paramArrayList)
  {
    this.photoTag = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photoTag = ((ArrayList)paramJceInputStream.read(cache_photoTag, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.photoTag != null) {
      paramJceOutputStream.write(this.photoTag, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     FileUpload.stPhotoTags
 * JD-Core Version:    0.7.0.1
 */