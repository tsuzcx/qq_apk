package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BubbleRecommendRsp
  extends JceStruct
{
  static CommonRsp cache_stRet = new CommonRsp();
  static ArrayList<BubbleInfo> cache_vItems = new ArrayList();
  public CommonRsp stRet;
  public ArrayList<BubbleInfo> vItems;
  
  static
  {
    BubbleInfo localBubbleInfo = new BubbleInfo();
    cache_vItems.add(localBubbleInfo);
  }
  
  public BubbleRecommendRsp() {}
  
  public BubbleRecommendRsp(CommonRsp paramCommonRsp, ArrayList<BubbleInfo> paramArrayList)
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
    if (this.stRet != null) {
      paramJceOutputStream.write(this.stRet, 0);
    }
    if (this.vItems != null) {
      paramJceOutputStream.write(this.vItems, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.BubbleRecommendRsp
 * JD-Core Version:    0.7.0.1
 */