package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class faiss_search_result
  extends JceStruct
{
  static comm_page_info cache_page_info = new comm_page_info();
  static ArrayList<Photo> cache_photolist = new ArrayList();
  public String categoryid = "";
  public comm_page_info page_info = null;
  public ArrayList<Photo> photolist = null;
  
  static
  {
    Photo localPhoto = new Photo();
    cache_photolist.add(localPhoto);
  }
  
  public faiss_search_result() {}
  
  public faiss_search_result(ArrayList<Photo> paramArrayList, comm_page_info paramcomm_page_info, String paramString)
  {
    this.photolist = paramArrayList;
    this.page_info = paramcomm_page_info;
    this.categoryid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photolist = ((ArrayList)paramJceInputStream.read(cache_photolist, 0, false));
    this.page_info = ((comm_page_info)paramJceInputStream.read(cache_page_info, 1, false));
    this.categoryid = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.photolist;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.page_info;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.categoryid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.faiss_search_result
 * JD-Core Version:    0.7.0.1
 */