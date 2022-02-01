package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoSearchBoxItemElem
  extends JceStruct
{
  static face_show_info cache_face_show = new face_show_info();
  static int cache_type;
  public String categoryid = "";
  public String desc = "";
  public face_show_info face_show = null;
  public int type = 0;
  public String url = "";
  
  public PhotoSearchBoxItemElem() {}
  
  public PhotoSearchBoxItemElem(int paramInt, String paramString1, String paramString2, face_show_info paramface_show_info, String paramString3)
  {
    this.type = paramInt;
    this.categoryid = paramString1;
    this.desc = paramString2;
    this.face_show = paramface_show_info;
    this.url = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.categoryid = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.face_show = ((face_show_info)paramJceInputStream.read(cache_face_show, 3, false));
    this.url = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    Object localObject = this.categoryid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.face_show;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.PhotoSearchBoxItemElem
 * JD-Core Version:    0.7.0.1
 */