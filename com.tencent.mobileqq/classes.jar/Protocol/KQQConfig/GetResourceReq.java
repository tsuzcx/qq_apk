package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetResourceReq
  extends JceStruct
{
  static ArrayList<GetResourceReqInfo> cache_vecResReqInfo;
  public short sLanCodeType = 0;
  public ArrayList<GetResourceReqInfo> vecResReqInfo = null;
  
  public GetResourceReq() {}
  
  public GetResourceReq(ArrayList<GetResourceReqInfo> paramArrayList, short paramShort)
  {
    this.vecResReqInfo = paramArrayList;
    this.sLanCodeType = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vecResReqInfo == null)
    {
      cache_vecResReqInfo = new ArrayList();
      GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
      cache_vecResReqInfo.add(localGetResourceReqInfo);
    }
    this.vecResReqInfo = ((ArrayList)paramJceInputStream.read(cache_vecResReqInfo, 1, true));
    this.sLanCodeType = paramJceInputStream.read(this.sLanCodeType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResReqInfo, 1);
    paramJceOutputStream.write(this.sLanCodeType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceReq
 * JD-Core Version:    0.7.0.1
 */