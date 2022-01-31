package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cluster_identify_face_req
  extends JceStruct
{
  static ArrayList<Float> cache_feature = new ArrayList();
  static int cache_mode = 0;
  public ArrayList<Float> feature;
  public String img = "";
  public boolean is_demo;
  public int mode = 0;
  public long op_uin;
  
  static
  {
    cache_feature.add(Float.valueOf(0.0F));
  }
  
  public cluster_identify_face_req() {}
  
  public cluster_identify_face_req(long paramLong, ArrayList<Float> paramArrayList, int paramInt, String paramString, boolean paramBoolean)
  {
    this.op_uin = paramLong;
    this.feature = paramArrayList;
    this.mode = paramInt;
    this.img = paramString;
    this.is_demo = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op_uin = paramJceInputStream.read(this.op_uin, 0, false);
    this.feature = ((ArrayList)paramJceInputStream.read(cache_feature, 1, false));
    this.mode = paramJceInputStream.read(this.mode, 2, false);
    this.img = paramJceInputStream.readString(3, false);
    this.is_demo = paramJceInputStream.read(this.is_demo, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op_uin, 0);
    if (this.feature != null) {
      paramJceOutputStream.write(this.feature, 1);
    }
    paramJceOutputStream.write(this.mode, 2);
    if (this.img != null) {
      paramJceOutputStream.write(this.img, 3);
    }
    paramJceOutputStream.write(this.is_demo, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.cluster_identify_face_req
 * JD-Core Version:    0.7.0.1
 */