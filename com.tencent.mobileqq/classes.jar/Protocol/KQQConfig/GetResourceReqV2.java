package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetResourceReqV2
  extends JceStruct
{
  static ArrayList<GetResourceReqInfoV2> cache_vecResReqInfo = new ArrayList();
  public byte cReqVer;
  public int iAppid;
  public int iPluginType = 64;
  public String strModel = "";
  public ArrayList<GetResourceReqInfoV2> vecResReqInfo;
  
  static
  {
    GetResourceReqInfoV2 localGetResourceReqInfoV2 = new GetResourceReqInfoV2();
    cache_vecResReqInfo.add(localGetResourceReqInfoV2);
  }
  
  public GetResourceReqV2() {}
  
  public GetResourceReqV2(ArrayList<GetResourceReqInfoV2> paramArrayList, int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    this.vecResReqInfo = paramArrayList;
    this.iPluginType = paramInt1;
    this.strModel = paramString;
    this.iAppid = paramInt2;
    this.cReqVer = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecResReqInfo = ((ArrayList)paramJceInputStream.read(cache_vecResReqInfo, 1, true));
    this.iPluginType = paramJceInputStream.read(this.iPluginType, 2, false);
    this.strModel = paramJceInputStream.readString(3, false);
    this.iAppid = paramJceInputStream.read(this.iAppid, 4, false);
    this.cReqVer = paramJceInputStream.read(this.cReqVer, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vecResReqInfo, 1);
    paramJceOutputStream.write(this.iPluginType, 2);
    if (this.strModel != null) {
      paramJceOutputStream.write(this.strModel, 3);
    }
    paramJceOutputStream.write(this.iAppid, 4);
    paramJceOutputStream.write(this.cReqVer, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceReqV2
 * JD-Core Version:    0.7.0.1
 */