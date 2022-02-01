package NS_MOBILE_PHOTO;

import NS_MOBILE_FEEDS.s_picdata;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class CategoryOpReq
  extends JceStruct
{
  static Map<String, ArrayList<String>> cache_category_groupids;
  static Map<String, category_face_confirm_info> cache_groupid_confirm_info;
  static Map<String, ArrayList<s_picdata>> cache_groupid_photos = new HashMap();
  static int cache_op;
  public Map<String, ArrayList<String>> category_groupids = null;
  public Map<String, category_face_confirm_info> groupid_confirm_info = null;
  public Map<String, ArrayList<s_picdata>> groupid_photos = null;
  public int op = 0;
  public long op_uin = 0L;
  
  static
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new s_picdata());
    cache_groupid_photos.put("", localObject);
    cache_groupid_confirm_info = new HashMap();
    localObject = new category_face_confirm_info();
    cache_groupid_confirm_info.put("", localObject);
    cache_category_groupids = new HashMap();
    localObject = new ArrayList();
    ((ArrayList)localObject).add("");
    cache_category_groupids.put("", localObject);
  }
  
  public CategoryOpReq() {}
  
  public CategoryOpReq(long paramLong, int paramInt, Map<String, ArrayList<s_picdata>> paramMap, Map<String, category_face_confirm_info> paramMap1, Map<String, ArrayList<String>> paramMap2)
  {
    this.op_uin = paramLong;
    this.op = paramInt;
    this.groupid_photos = paramMap;
    this.groupid_confirm_info = paramMap1;
    this.category_groupids = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.op_uin = paramJceInputStream.read(this.op_uin, 0, false);
    this.op = paramJceInputStream.read(this.op, 1, false);
    this.groupid_photos = ((Map)paramJceInputStream.read(cache_groupid_photos, 2, false));
    this.groupid_confirm_info = ((Map)paramJceInputStream.read(cache_groupid_confirm_info, 3, false));
    this.category_groupids = ((Map)paramJceInputStream.read(cache_category_groupids, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.op_uin, 0);
    paramJceOutputStream.write(this.op, 1);
    Map localMap = this.groupid_photos;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 2);
    }
    localMap = this.groupid_confirm_info;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 3);
    }
    localMap = this.category_groupids;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.CategoryOpReq
 * JD-Core Version:    0.7.0.1
 */