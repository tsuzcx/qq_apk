package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PhotoInfos
  extends JceStruct
{
  static ArrayList<Float> cache_feature;
  static int cache_mode = 0;
  public ArrayList<Float> feature = null;
  public String img = "";
  public int mode = 0;
  
  static
  {
    cache_feature = new ArrayList();
    cache_feature.add(Float.valueOf(0.0F));
  }
  
  public PhotoInfos() {}
  
  public PhotoInfos(int paramInt, ArrayList<Float> paramArrayList, String paramString)
  {
    this.mode = paramInt;
    this.feature = paramArrayList;
    this.img = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mode = paramJceInputStream.read(this.mode, 0, false);
    this.feature = ((ArrayList)paramJceInputStream.read(cache_feature, 1, false));
    this.img = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mode, 0);
    if (this.feature != null) {
      paramJceOutputStream.write(this.feature, 1);
    }
    if (this.img != null) {
      paramJceOutputStream.write(this.img, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoInfos
 * JD-Core Version:    0.7.0.1
 */