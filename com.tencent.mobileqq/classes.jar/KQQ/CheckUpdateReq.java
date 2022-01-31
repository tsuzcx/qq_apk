package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CheckUpdateReq
  extends JceStruct
{
  static ArrayList cache_vecReqPkg;
  public boolean isSupportSubPack;
  public ArrayList vecReqPkg;
  
  public CheckUpdateReq() {}
  
  public CheckUpdateReq(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.vecReqPkg = paramArrayList;
    this.isSupportSubPack = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecReqPkg == null)
    {
      cache_vecReqPkg = new ArrayList();
      ReqItem localReqItem = new ReqItem();
      cache_vecReqPkg.add(localReqItem);
    }
    this.vecReqPkg = ((ArrayList)paramJceInputStream.read(cache_vecReqPkg, 0, true));
    this.isSupportSubPack = paramJceInputStream.read(this.isSupportSubPack, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecReqPkg, 0);
    paramJceOutputStream.write(this.isSupportSubPack, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     KQQ.CheckUpdateReq
 * JD-Core Version:    0.7.0.1
 */