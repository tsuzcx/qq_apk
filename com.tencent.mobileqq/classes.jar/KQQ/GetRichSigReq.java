package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetRichSigReq
  extends JceStruct
{
  static ArrayList<ReqRichInfo> cache_vstReqRichInfo;
  public boolean checkupdate = false;
  public boolean get_large_tlv = false;
  public boolean showdatesig = false;
  public ArrayList<ReqRichInfo> vstReqRichInfo = null;
  
  public GetRichSigReq() {}
  
  public GetRichSigReq(ArrayList<ReqRichInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.vstReqRichInfo = paramArrayList;
    this.checkupdate = paramBoolean1;
    this.showdatesig = paramBoolean2;
    this.get_large_tlv = paramBoolean3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vstReqRichInfo == null)
    {
      cache_vstReqRichInfo = new ArrayList();
      ReqRichInfo localReqRichInfo = new ReqRichInfo();
      cache_vstReqRichInfo.add(localReqRichInfo);
    }
    this.vstReqRichInfo = ((ArrayList)paramJceInputStream.read(cache_vstReqRichInfo, 1, true));
    this.checkupdate = paramJceInputStream.read(this.checkupdate, 2, false);
    this.showdatesig = paramJceInputStream.read(this.showdatesig, 3, false);
    this.get_large_tlv = paramJceInputStream.read(this.get_large_tlv, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vstReqRichInfo, 1);
    paramJceOutputStream.write(this.checkupdate, 2);
    paramJceOutputStream.write(this.showdatesig, 3);
    paramJceOutputStream.write(this.get_large_tlv, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     KQQ.GetRichSigReq
 * JD-Core Version:    0.7.0.1
 */