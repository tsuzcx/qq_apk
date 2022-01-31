package WEBAPP_FAMOUS;

import NS_FAMOUS_BASE.SchoolSingleGameItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetBottomNaviRsp
  extends JceStruct
{
  static Map cache_app_list;
  static ArrayList cache_vec_out_app = new ArrayList();
  public Map app_list;
  public int bitmap_flag;
  public ArrayList vec_out_app;
  
  static
  {
    Object localObject = new ActInfo();
    cache_vec_out_app.add(localObject);
    cache_app_list = new HashMap();
    localObject = new ArrayList();
    ((ArrayList)localObject).add(new SchoolSingleGameItem());
    cache_app_list.put("", localObject);
  }
  
  public GetBottomNaviRsp() {}
  
  public GetBottomNaviRsp(ArrayList paramArrayList, Map paramMap, int paramInt)
  {
    this.vec_out_app = paramArrayList;
    this.app_list = paramMap;
    this.bitmap_flag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vec_out_app = ((ArrayList)paramJceInputStream.read(cache_vec_out_app, 0, false));
    this.app_list = ((Map)paramJceInputStream.read(cache_app_list, 1, false));
    this.bitmap_flag = paramJceInputStream.read(this.bitmap_flag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vec_out_app != null) {
      paramJceOutputStream.write(this.vec_out_app, 0);
    }
    if (this.app_list != null) {
      paramJceOutputStream.write(this.app_list, 1);
    }
    paramJceOutputStream.write(this.bitmap_flag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     WEBAPP_FAMOUS.GetBottomNaviRsp
 * JD-Core Version:    0.7.0.1
 */