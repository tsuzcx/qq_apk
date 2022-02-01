package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class stGetFeedIconOpReq
  extends JceStruct
{
  static stFeedOpInfo cache_opInfo = new stFeedOpInfo();
  static ArrayList<stFeedOpInfo> cache_postOpInfos;
  static ArrayList<stFeedOpInfo> cache_preOpInfos = new ArrayList();
  public stFeedOpInfo opInfo = null;
  public ArrayList<stFeedOpInfo> postOpInfos = null;
  public ArrayList<stFeedOpInfo> preOpInfos = null;
  
  static
  {
    stFeedOpInfo localstFeedOpInfo = new stFeedOpInfo();
    cache_preOpInfos.add(localstFeedOpInfo);
    cache_postOpInfos = new ArrayList();
    localstFeedOpInfo = new stFeedOpInfo();
    cache_postOpInfos.add(localstFeedOpInfo);
  }
  
  public stGetFeedIconOpReq() {}
  
  public stGetFeedIconOpReq(stFeedOpInfo paramstFeedOpInfo, ArrayList<stFeedOpInfo> paramArrayList1, ArrayList<stFeedOpInfo> paramArrayList2)
  {
    this.opInfo = paramstFeedOpInfo;
    this.preOpInfos = paramArrayList1;
    this.postOpInfos = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.opInfo = ((stFeedOpInfo)paramJceInputStream.read(cache_opInfo, 0, false));
    this.preOpInfos = ((ArrayList)paramJceInputStream.read(cache_preOpInfos, 1, false));
    this.postOpInfos = ((ArrayList)paramJceInputStream.read(cache_postOpInfos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.opInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.preOpInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.postOpInfos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetFeedIconOpReq
 * JD-Core Version:    0.7.0.1
 */