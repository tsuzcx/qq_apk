package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class FontRecommendRsp
  extends JceStruct
{
  static CommonRsp cache_stRet = new CommonRsp();
  static ArrayList<FontInfo> cache_vItems = new ArrayList();
  public CommonRsp stRet = null;
  public ArrayList<FontInfo> vItems = null;
  
  static
  {
    FontInfo localFontInfo = new FontInfo();
    cache_vItems.add(localFontInfo);
  }
  
  public FontRecommendRsp() {}
  
  public FontRecommendRsp(CommonRsp paramCommonRsp, ArrayList<FontInfo> paramArrayList)
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
 * Qualified Name:     QC.FontRecommendRsp
 * JD-Core Version:    0.7.0.1
 */