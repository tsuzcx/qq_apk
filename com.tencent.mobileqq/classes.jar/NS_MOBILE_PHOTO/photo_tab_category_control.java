package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class photo_tab_category_control
  extends JceStruct
{
  static ArrayList<photo_tab_categroy_info> cache_category_infos = new ArrayList();
  public ArrayList<photo_tab_categroy_info> category_infos = null;
  public boolean is_visible = false;
  
  static
  {
    photo_tab_categroy_info localphoto_tab_categroy_info = new photo_tab_categroy_info();
    cache_category_infos.add(localphoto_tab_categroy_info);
  }
  
  public photo_tab_category_control() {}
  
  public photo_tab_category_control(boolean paramBoolean, ArrayList<photo_tab_categroy_info> paramArrayList)
  {
    this.is_visible = paramBoolean;
    this.category_infos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.is_visible = paramJceInputStream.read(this.is_visible, 0, false);
    this.category_infos = ((ArrayList)paramJceInputStream.read(cache_category_infos, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.is_visible, 0);
    ArrayList localArrayList = this.category_infos;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.photo_tab_category_control
 * JD-Core Version:    0.7.0.1
 */