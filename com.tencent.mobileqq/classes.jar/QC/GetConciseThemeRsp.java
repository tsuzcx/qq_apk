package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetConciseThemeRsp
  extends JceStruct
{
  static CommonRsp cache_stRet = new CommonRsp();
  static ArrayList<ItemDisDetail> cache_vItems = new ArrayList();
  public CommonRsp stRet = null;
  public ArrayList<ItemDisDetail> vItems = null;
  
  static
  {
    ItemDisDetail localItemDisDetail = new ItemDisDetail();
    cache_vItems.add(localItemDisDetail);
  }
  
  public GetConciseThemeRsp() {}
  
  public GetConciseThemeRsp(CommonRsp paramCommonRsp, ArrayList<ItemDisDetail> paramArrayList)
  {
    this.stRet = paramCommonRsp;
    this.vItems = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stRet = ((CommonRsp)paramJceInputStream.read(cache_stRet, 0, false));
    this.vItems = ((ArrayList)paramJceInputStream.read(cache_vItems, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stRet;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.vItems;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.GetConciseThemeRsp
 * JD-Core Version:    0.7.0.1
 */