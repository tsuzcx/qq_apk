package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class edit_batch_photo_req
  extends JceStruct
{
  static EditPhoto cache_PhotoInfo;
  static Map<Integer, String> cache_busi_param;
  static ArrayList<String> cache_picid_list = new ArrayList();
  static Map<String, EditPhoto> cache_picid_time_list;
  public EditPhoto PhotoInfo;
  public String albumid = "";
  public Map<Integer, String> busi_param;
  public int operatype;
  public ArrayList<String> picid_list;
  public Map<String, EditPhoto> picid_time_list;
  
  static
  {
    cache_picid_list.add("");
    cache_PhotoInfo = new EditPhoto();
    cache_busi_param = new HashMap();
    cache_busi_param.put(Integer.valueOf(0), "");
    cache_picid_time_list = new HashMap();
    EditPhoto localEditPhoto = new EditPhoto();
    cache_picid_time_list.put("", localEditPhoto);
  }
  
  public edit_batch_photo_req() {}
  
  public edit_batch_photo_req(String paramString, ArrayList<String> paramArrayList, EditPhoto paramEditPhoto, Map<Integer, String> paramMap, int paramInt, Map<String, EditPhoto> paramMap1)
  {
    this.albumid = paramString;
    this.picid_list = paramArrayList;
    this.PhotoInfo = paramEditPhoto;
    this.busi_param = paramMap;
    this.operatype = paramInt;
    this.picid_time_list = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    this.picid_list = ((ArrayList)paramJceInputStream.read(cache_picid_list, 1, true));
    this.PhotoInfo = ((EditPhoto)paramJceInputStream.read(cache_PhotoInfo, 2, true));
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 3, false));
    this.operatype = paramJceInputStream.read(this.operatype, 4, false);
    this.picid_time_list = ((Map)paramJceInputStream.read(cache_picid_time_list, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.picid_list, 1);
    paramJceOutputStream.write(this.PhotoInfo, 2);
    Map localMap = this.busi_param;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 3);
    }
    paramJceOutputStream.write(this.operatype, 4);
    localMap = this.picid_time_list;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.edit_batch_photo_req
 * JD-Core Version:    0.7.0.1
 */