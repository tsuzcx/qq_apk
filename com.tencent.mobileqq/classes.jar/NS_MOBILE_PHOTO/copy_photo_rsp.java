package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class copy_photo_rsp
  extends JceStruct
{
  static ArrayList<st_copy_photo> cache_fails = new ArrayList();
  public ArrayList<st_copy_photo> fails = null;
  
  static
  {
    st_copy_photo localst_copy_photo = new st_copy_photo();
    cache_fails.add(localst_copy_photo);
  }
  
  public copy_photo_rsp() {}
  
  public copy_photo_rsp(ArrayList<st_copy_photo> paramArrayList)
  {
    this.fails = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fails = ((ArrayList)paramJceInputStream.read(cache_fails, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fails, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.copy_photo_rsp
 * JD-Core Version:    0.7.0.1
 */