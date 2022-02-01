package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class PhotoInfos
  extends JceStruct
{
  static ArrayList<Float> cache_feature = new ArrayList();
  static int cache_mode;
  public ArrayList<Float> feature = null;
  public String img = "";
  public int mode = 0;
  
  static
  {
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
    Object localObject = this.feature;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.img;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoInfos
 * JD-Core Version:    0.7.0.1
 */